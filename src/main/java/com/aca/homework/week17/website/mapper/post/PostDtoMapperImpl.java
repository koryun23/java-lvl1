package com.aca.homework.week17.website.mapper.post;

import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.facade.post.dto.ImageDto;
import com.aca.homework.week17.website.facade.post.dto.PostDto;
import com.aca.homework.week17.website.mapper.Mapper;

import java.util.Collections;
import java.util.List;

public class PostDtoMapperImpl implements PostDtoMapper {

    @Override
    public PostDto apply(Post value) {
        return new PostDto(value.getTitle(), value.getDescription(), Collections.emptyList());
    }
}
