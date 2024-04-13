package com.api.TestHub.controller;

import com.api.TestHub.domain.Test;
import com.api.TestHub.dto.testDto.TestCreateDto;
import com.api.TestHub.dto.testDto.TestDto;
import com.api.TestHub.dto.testDto.TestListDto;
import com.api.TestHub.dto.testDto.TestUpdateDto;
import com.api.TestHub.exception.BadRequestException;
import com.api.TestHub.exception.NotFoundException;
import com.api.TestHub.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/all")
    public ResponseEntity<List<TestListDto>> findAllTest() {
        List<TestListDto> testListDtos = testService.getAllTests();
        return new ResponseEntity<>(testListDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestDto> findTest(@PathVariable("id") Long id) throws NotFoundException {
        TestDto testDto = testService.getTest(id);
        return new ResponseEntity<>(testDto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createTest(@RequestBody TestCreateDto testCreateDto) {
        testService.createTest(testCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> createTest(@PathVariable("id") Long id, @RequestBody TestUpdateDto testUpdateDto) throws NotFoundException, BadRequestException {
        testService.updateTest(id, testUpdateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
