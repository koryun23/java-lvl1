package com.aca.homework.week21.post.mapper;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;

import java.util.function.Function;

public interface PostDtoMapper extends Function<Post, PostDto> {

    @Override
    PostDto apply(Post post);
}
