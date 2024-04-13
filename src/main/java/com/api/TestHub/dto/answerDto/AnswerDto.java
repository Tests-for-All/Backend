package com.api.TestHub.dto.answerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private Long id;
    private String text;
    private Boolean isTrue;
}
