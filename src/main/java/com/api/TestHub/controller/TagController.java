package com.api.TestHub.controller;

import com.api.TestHub.domain.Tag;
import com.api.TestHub.domain.Test;
import com.api.TestHub.dto.tagDto.TagCreateDto;
import com.api.TestHub.dto.tagDto.TagListDto;
import com.api.TestHub.dto.tagDto.TagUpdateDto;
import com.api.TestHub.dto.testDto.TestCreateDto;
import com.api.TestHub.dto.testDto.TestListDto;
import com.api.TestHub.dto.testDto.TestUpdateDto;
import com.api.TestHub.service.TagService;
import com.api.TestHub.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/all")
    public ResponseEntity<List<TagListDto>> findAllTag() {
        List<TagListDto> testListDtos = tagService.getAllTags();
        return new ResponseEntity<>(testListDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findTag(@PathVariable("id") Long id) {
        Tag tag = tagService.getTag(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createTag(@RequestBody TagCreateDto tagCreateDto) {
        tagService.createTag(tagCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> createTag(@PathVariable("id") Long id, @RequestBody TagUpdateDto tagUpdateDto) {
        tagService.updateTag(id, tagUpdateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
