package com.api.TestHub.service;

import com.api.TestHub.domain.Question;
import com.api.TestHub.domain.Tag;
import com.api.TestHub.dto.questionDto.*;
import com.api.TestHub.dto.tagDto.TagCreateDto;
import com.api.TestHub.dto.tagDto.TagListDto;
import com.api.TestHub.dto.tagDto.TagUpdateDto;

import java.util.List;

public interface QuestionService {
    List<QuestionListDto> getAllQuestions();
    QuestionDto getQuestion(Long id);
    QuestionHiddenDto getQuestionHidden(Long id);
    Question createQuestion(QuestionCreateDto questionCreateDto);
    void updateQuestion(Long id, QuestionUpdateDto questionUpdateDto);
}
