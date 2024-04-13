package com.api.TestHub.dto.questionDto;

import com.api.TestHub.dto.answerDto.AnswerDto;
import com.api.TestHub.dto.answerDto.AnswerHiddenDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionHiddenDto {
    private Long id;
    private String name;
    private String details;
    private List<AnswerHiddenDto> answerHiddenDtos;
}
