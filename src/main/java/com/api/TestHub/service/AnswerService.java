package com.api.TestHub.service;

import com.api.TestHub.dto.answerDto.AnswerCreateDto;
import com.api.TestHub.dto.answerDto.AnswerDto;
import com.api.TestHub.dto.answerDto.AnswerHiddenDto;
import com.api.TestHub.dto.answerDto.AnswerUpdateDto;
import com.api.TestHub.dto.questionDto.*;

import java.util.List;

public interface AnswerService {
    List<AnswerDto> getAllAnswers();
    AnswerHiddenDto getAnswersHidden(Long id);
    AnswerDto getAnswer(Long id);
    void createAnswer(AnswerCreateDto answerCreateDto);
    void updateAnswer(Long id, AnswerUpdateDto answerUpdateDto);
}
