package com.aca.homework.week21.post.dto;

import java.util.List;
import java.util.Objects;

public class PostListRetrievalDto {

    private List<PostDto> postDtoList;
    private String error;

    public PostListRetrievalDto(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
    }

    public PostListRetrievalDto(String error) {
        this.error = error;
    }

    public PostListRetrievalDto() {
    }

    public List<PostDto> getPostDtoList() {
        return postDtoList;
    }

    public void setPostDtoList(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostListRetrievalDto that = (PostListRetrievalDto) o;
        return Objects.equals(postDtoList, that.postDtoList) && Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postDtoList, error);
    }

    @Override
    public String toString() {
        return "PostsRetrievalDto{" +
                "postDtoList=" + postDtoList +
                "error=" + error +
                '}';
    }
}
