package com.aca.homework.week21.post.mapper;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.service.core.PostCreationParams;

import java.util.function.Function;

public interface PostCreationParamsMapper extends Function<PostDto, PostCreationParams> {

    @Override
    PostCreationParams apply(PostDto post);
}
