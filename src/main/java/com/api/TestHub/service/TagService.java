package com.api.TestHub.service;

import com.api.TestHub.domain.Tag;
import com.api.TestHub.dto.tagDto.TagCreateDto;
import com.api.TestHub.dto.tagDto.TagListDto;
import com.api.TestHub.dto.tagDto.TagUpdateDto;

import java.util.List;

public interface TagService {
    List<TagListDto> getAllTags();
    List<Tag> getAllTagsById(List<Long> ids);
    Tag getTag(Long id);
    void createTag(TagCreateDto tagCreateDto);
    void updateTag(Long id, TagUpdateDto tagUpdateDto);
}
