package com.api.TestHub.dto.testDto;

import com.api.TestHub.dto.questionDto.QuestionCreateDto;
import com.api.TestHub.dto.tagDto.TagListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCreateDto {
    private String name;
    private List<TagListDto> tagListDtos;
    private List<QuestionCreateDto> questionCreateDtos;
}
