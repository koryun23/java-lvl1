package com.aca.homework.week21.post.mapper;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.service.core.PostCreationParams;
import org.springframework.stereotype.Component;

@Component
public class PostCreationParamsMapperImpl implements PostCreationParamsMapper{
    @Override
    public PostCreationParams apply(PostDto postDto) {
        return new PostCreationParams(
                postDto.getCreationDate(),
                postDto.getContent(),
                postDto.getCreatedBy()
        );
    }
}
