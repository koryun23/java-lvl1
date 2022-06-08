package com.aca.homework.week21.post.dto;

import java.util.List;
import java.util.Objects;

public class PostUploadResponseDto {

    private PostDto postDto;

    private List<String> errors;

    public PostUploadResponseDto(PostDto postDto) {
        this.postDto = postDto;
    }

    public PostUploadResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostUploadResponseDto that = (PostUploadResponseDto) o;
        return Objects.equals(postDto, that.postDto) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postDto, errors);
    }

    @Override
    public String toString() {
        return "PostUploadResponseDto{" +
                "postDto=" + postDto +
                ", errors=" + errors +
                '}';
    }
}
