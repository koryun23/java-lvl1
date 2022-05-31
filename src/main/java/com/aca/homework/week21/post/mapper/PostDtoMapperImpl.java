package com.aca.homework.week21.post.mapper;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostDtoMapperImpl implements PostDtoMapper{

    private Post post;

    public PostDtoMapperImpl(Post post) {
        this.post = post;
    }


    @Override
    public PostDto apply(Post post) {
        return new PostDto(
                post.getCreationDate(),
                post.getContent(),
                post.getCreatedBy()
        );
    }
}
