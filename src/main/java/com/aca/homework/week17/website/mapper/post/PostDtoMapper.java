package com.aca.homework.week17.website.mapper.post;

import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.facade.post.dto.ImageDto;
import com.aca.homework.week17.website.facade.post.dto.PostDto;
import com.aca.homework.week17.website.mapper.Mapper;

import java.util.List;

public interface PostDtoMapper extends Mapper<Post, PostDto> {
    PostDto apply(Post post);
}
