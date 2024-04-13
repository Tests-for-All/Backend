package com.api.TestHub.service.impl;

import com.api.TestHub.domain.Tag;
import com.api.TestHub.dto.tagDto.TagCreateDto;
import com.api.TestHub.dto.tagDto.TagListDto;
import com.api.TestHub.dto.tagDto.TagUpdateDto;
import com.api.TestHub.repository.TagRepository;
import com.api.TestHub.service.TagService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final ModelMapper modelMapper;
    private final TagRepository tagRepository;

    @Override
    public List<TagListDto> getAllTags() {
        return tagRepository.findAll()
                .stream().map(tag -> modelMapper.map(tag, TagListDto.class))
                .toList();
    }

    @Override
    public List<Tag> getAllTagsById(List<Long> ids) {
        List<Tag> tags = tagRepository.findAllById(ids);
        return tags;
    }

    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public void createTag(TagCreateDto tagCreateDto) {
        tagRepository.save(modelMapper.map(tagCreateDto, Tag.class));
    }

    @Override
    public void updateTag(Long id, TagUpdateDto tagUpdateDto) {
        tagRepository.save(modelMapper.map(tagUpdateDto, Tag.class));
    }
}
