package com.api.TestHub.service.impl;

import com.api.TestHub.domain.Answer;
import com.api.TestHub.dto.answerDto.AnswerCreateDto;
import com.api.TestHub.dto.answerDto.AnswerDto;
import com.api.TestHub.dto.answerDto.AnswerHiddenDto;
import com.api.TestHub.dto.answerDto.AnswerUpdateDto;
import com.api.TestHub.repository.AnswerRepository;
import com.api.TestHub.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final ModelMapper modelMapper;
    private final AnswerRepository answerRepository;

    @Override
    public List<AnswerDto> getAllAnswers() {
        return answerRepository.findAll().stream()
                .map(answer -> modelMapper.map(answer, AnswerDto.class))
                .toList();
    }

    @Override
    public AnswerHiddenDto getAnswersHidden(Long id) {
        return modelMapper.map(answerRepository.findById(id).get(), AnswerHiddenDto.class);
    }

    @Override
    public AnswerDto getAnswer(Long id) {
        return modelMapper.map(answerRepository.findById(id).get(), AnswerDto.class);
    }

    @Override
    public Answer createAnswer(AnswerCreateDto answerCreateDto) {
        Answer answer = modelMapper.map(answerCreateDto, Answer.class);
        return answerRepository.save(answer);
    }

    @Override
    public void updateAnswer(Long id, AnswerUpdateDto answerUpdateDto) {
        Answer answer = answerRepository.findById(answerUpdateDto.getId()).get();
        answerRepository.save(answer);
    }
}
