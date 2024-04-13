package com.api.TestHub.service.impl;

import com.api.TestHub.domain.Answer;
import com.api.TestHub.domain.Question;
import com.api.TestHub.domain.Tag;
import com.api.TestHub.dto.questionDto.*;
import com.api.TestHub.repository.AnswerRepository;
import com.api.TestHub.repository.QuestionRepository;
import com.api.TestHub.service.AnswerService;
import com.api.TestHub.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final ModelMapper modelMapper;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final AnswerService answerService;

    @Override
    public List<QuestionListDto> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(question -> modelMapper.map(question, QuestionListDto.class))
                .toList();
    }

    @Override
    public QuestionDto getQuestion(Long id) {
        return modelMapper.map(questionRepository.findById(id).get(), QuestionDto.class);
    }

    @Override
    public QuestionHiddenDto getQuestionHidden(Long id) {
        return modelMapper.map(questionRepository.findById(id).get(), QuestionHiddenDto.class);
    }

    @Override
    public void createQuestion(QuestionCreateDto questionCreateDto) {
        questionCreateDto.getAnswerCreateDtos().forEach(answerService::createAnswer);
        Question question = modelMapper.map(questionCreateDto, Question.class);

        questionRepository.save(question);
    }

    @Override
    public void updateQuestion(Long id, QuestionUpdateDto questionUpdateDto) {
        questionRepository.save(modelMapper.map(questionUpdateDto, Question.class));
    }
}
