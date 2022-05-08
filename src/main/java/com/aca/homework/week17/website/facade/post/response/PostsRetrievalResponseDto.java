package com.aca.homework.week17.website.facade.post.response;

import com.aca.homework.week17.website.facade.post.dto.PostDto;
import com.aca.homework.week17.website.facade.post.dto.UserDto;

import java.util.List;
import java.util.Objects;

public class PostsRetrievalResponseDto {
    private final UserDto userDto;
    private final List<PostDto> postDtos;

    public PostsRetrievalResponseDto(UserDto userDto, List<PostDto> postDtos) {
        this.userDto = userDto;
        this.postDtos = postDtos;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public List<PostDto> getPostDtos() {
        return postDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsRetrievalResponseDto that = (PostsRetrievalResponseDto) o;
        return Objects.equals(userDto, that.userDto) && Objects.equals(postDtos, that.postDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDto, postDtos);
    }

    @Override
    public String toString() {
        return "PostsRetrievalResponseDto{" +
                "userDto=" + userDto +
                ", postDtos=" + postDtos +
                '}';
    }


}
