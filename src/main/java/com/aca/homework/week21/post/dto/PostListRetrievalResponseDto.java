package com.aca.homework.week21.post.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PostListRetrievalResponseDto {
    private List<PostDto> postDtoList;

    private String[] errors;

    public PostListRetrievalResponseDto(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
    }

    public PostListRetrievalResponseDto(String[] errors) {
        this.errors = errors;
    }

    public List<PostDto> getPostDtoList() {
        return postDtoList;
    }

    public void setPostDtoList(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostListRetrievalResponseDto that = (PostListRetrievalResponseDto) o;
        return Objects.equals(postDtoList, that.postDtoList) && Arrays.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(postDtoList);
        result = 31 * result + Arrays.hashCode(errors);
        return result;
    }

    @Override
    public String toString() {
        return "PostListRetrievalDto{" +
                "postDtoList=" + postDtoList +
                ", errors=" + Arrays.toString(errors) +
                '}';
    }
}
