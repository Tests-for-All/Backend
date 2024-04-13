package com.api.TestHub.controller;

import com.api.TestHub.dto.testDto.TestListDto;
import com.api.TestHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/tests")
    public ResponseEntity<List<TestListDto>> findAllTest() {
        List<TestListDto> testListDtos = userService.getAllTests();
        return new ResponseEntity<>(testListDtos, HttpStatus.OK);
    }
}
