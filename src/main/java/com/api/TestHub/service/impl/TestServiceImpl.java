package com.api.TestHub.service.impl;

import com.api.TestHub.domain.Question;
import com.api.TestHub.domain.Tag;
import com.api.TestHub.domain.Test;
import com.api.TestHub.domain.User;
import com.api.TestHub.dto.questionDto.QuestionListDto;
import com.api.TestHub.dto.tagDto.TagListDto;
import com.api.TestHub.dto.testDto.TestCreateDto;
import com.api.TestHub.dto.testDto.TestDto;
import com.api.TestHub.dto.testDto.TestListDto;
import com.api.TestHub.dto.testDto.TestUpdateDto;
import com.api.TestHub.exception.BadRequestException;
import com.api.TestHub.exception.NotFoundException;
import com.api.TestHub.repository.TagRepository;
import com.api.TestHub.repository.TestRepository;
import com.api.TestHub.service.QuestionService;
import com.api.TestHub.service.TagService;
import com.api.TestHub.service.TestService;
import com.api.TestHub.service.security.UserServiceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final ModelMapper modelMapper;
    private final TestRepository testRepository;
    private final TagRepository tagRepository;
    private final TagService tagService;
    private final UserServiceImpl userService;
    private final QuestionService questionService;

    @Override
    public List<TestListDto> getAllTests() {
        return testRepository.findAll()
                .stream().map(test -> modelMapper.map(test, TestListDto.class))
                .toList();
    }

    @Override
    public TestDto getTest(Long id) throws NotFoundException {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Test", "Test with id = " + id + " Not found"));
        TestDto testDto = modelMapper.map(test, TestDto.class);
        testDto.setQuestionListDtos(test.getQuestions().stream()
                .map(question -> modelMapper.map(question, QuestionListDto.class))
                .toList());
        return testDto;
    }

    @Override
    @Transactional
    public void createTest(TestCreateDto testCreateDto) {
        User user = userService.getCurrentUser();
        Test test = modelMapper.map(testCreateDto, Test.class);
        test.setUser(user);
        test.setTags(tagService.getAllTagsById(testCreateDto.getTagListDtos().stream().map(TagListDto::getId).toList()));
//        if (testCreateDto.getTagListDtos() != null && !testCreateDto.getTagListDtos().isEmpty()) {
//            List<Tag> tags = testCreateDto.getTagListDtos().stream()
//                    .map(tagDto -> modelMapper.map(tagDto, Tag.class))
//                    .map(tag -> tagRepository.findById(tag.getId()).get())
//                    .toList();
//            test.setTags(tags);
//        }
        List<Question> questions = testCreateDto.getQuestionCreateDtos()
                .stream()
                .map(questionService::createQuestion)
                .toList();
        test.setQuestions(questions);

        testRepository.save(test);
    }

    @Override
    public void updateTest(Long id, TestUpdateDto testUpdateDto) throws NotFoundException, BadRequestException {
        if (id != testUpdateDto.getId()) {
            throw new BadRequestException("Test", "Path Id(" + id + ") not equal Test Id(" + testUpdateDto.getId() + ")");
        }
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Test", "Test with id = " + id + " Not found"));

        test.setName(testUpdateDto.getName());
        testUpdateDto.getQuestionCreateDtos().forEach(questionService::createQuestion);

        testRepository.save(modelMapper.map(testUpdateDto, Test.class));
    }
}
