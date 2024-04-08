package com.api.TestHub.service.impl;

import com.api.TestHub.domain.Tag;
import com.api.TestHub.domain.Test;
import com.api.TestHub.domain.User;
import com.api.TestHub.dto.testDto.TestCreateDto;
import com.api.TestHub.dto.testDto.TestDto;
import com.api.TestHub.dto.testDto.TestListDto;
import com.api.TestHub.dto.testDto.TestUpdateDto;
import com.api.TestHub.repository.TagRepository;
import com.api.TestHub.repository.TestRepository;
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
    private final UserServiceImpl userService;

    @Override
    public List<TestListDto> getAllTests() {
        return testRepository.findAll()
                .stream().map(test -> modelMapper.map(test, TestListDto.class))
                .toList();
    }

    @Override
    public TestDto getTest(Long id) {
        Test test = testRepository.findById(id).get();
        return modelMapper.map(test, TestDto.class);
    }

    @Override
    @Transactional
    public void createTest(TestCreateDto testCreateDto) {
        User user = userService.getCurrentUser();
        Test test = modelMapper.map(testCreateDto, Test.class);
        test.setUser(user);
        if (testCreateDto.getTagListDtos() != null && !testCreateDto.getTagListDtos().isEmpty()) {
            List<Tag> tags = testCreateDto.getTagListDtos().stream()
                    .map(tagDto -> modelMapper.map(tagDto, Tag.class))
                    .map(tag -> tagRepository.findById(tag.getId()).get())
                    .toList();
            test.setTags(tags);
        }
        testRepository.save(test);
    }

    @Override
    public void updateTest(Long id, TestUpdateDto testUpdateDto) {
        testRepository.save(modelMapper.map(testUpdateDto, Test.class));
    }
}
