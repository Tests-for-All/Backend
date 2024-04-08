package com.api.TestHub.dto.testDto;

import com.api.TestHub.domain.Tag;
import com.api.TestHub.domain.User;
import com.api.TestHub.dto.tagDto.TagDto;
import com.api.TestHub.dto.userDto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private String id;
    private String name;
    private UserDto user;
    private List<Tag> tags;
}
