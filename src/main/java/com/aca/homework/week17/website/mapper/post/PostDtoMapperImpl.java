package com.aca.homework.week17.website.mapper.post;

import com.aca.homework.week17.website.entity.Post;
import com.aca.homework.week17.website.facade.post.dto.PostDto;
import com.aca.homework.week17.website.facade.post.dto.UserDto;
import com.aca.homework.week17.website.mapper.user.UserDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class PostDtoMapperImpl implements PostDtoMapper {

    private final UserDtoMapper userDtoMapper;

    public PostDtoMapperImpl(UserDtoMapper userDtoMapper) {
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public PostDto apply(Post value) {
        return new PostDto(value.getTitle(),
                value.getDescription(),
                Collections.emptyList(),
                userDtoMapper.apply(value.getUser())
        );
    }
}
