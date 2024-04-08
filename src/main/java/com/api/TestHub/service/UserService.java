package com.api.TestHub.service;

import com.api.TestHub.dto.testDto.TestListDto;

import java.util.List;

public interface UserService {
    List<TestListDto> getAllTests();
}
