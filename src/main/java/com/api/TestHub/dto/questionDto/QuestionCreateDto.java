package com.api.TestHub.dto.questionDto;

import com.api.TestHub.dto.answerDto.AnswerCreateDto;
import com.api.TestHub.dto.answerDto.AnswerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionCreateDto {
    private String name;
    private String details;
    private List<AnswerCreateDto> answerCreateDtos;
}
