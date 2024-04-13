package com.api.TestHub.service;

import com.api.TestHub.domain.Test;
import com.api.TestHub.dto.testDto.TestCreateDto;
import com.api.TestHub.dto.testDto.TestDto;
import com.api.TestHub.dto.testDto.TestListDto;
import com.api.TestHub.dto.testDto.TestUpdateDto;
import com.api.TestHub.exception.BadRequestException;
import com.api.TestHub.exception.NotFoundException;

import java.util.List;

public interface TestService {
    List<TestListDto> getAllTests();
    TestDto getTest(Long id) throws NotFoundException;
    void createTest(TestCreateDto testCreateDto);
    void updateTest(Long id, TestUpdateDto testUpdateDto) throws NotFoundException, BadRequestException;
}
