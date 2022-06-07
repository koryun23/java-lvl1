package com.aca.homework.week21.post.dto;

import java.util.List;
import java.util.Objects;

public class UploadResponseDto {
    private List<PostDto> postDtoList;

    private String error;

    public UploadResponseDto(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
    }

    public UploadResponseDto(String error) {
        this.error = error;
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
        UploadResponseDto that = (UploadResponseDto) o;
        return Objects.equals(postDtoList, that.postDtoList) && Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postDtoList, error);
    }

    @Override
    public String toString() {
        return "UploadResponseDto{" +
                "postDtoList=" + postDtoList +
                "error=" + error +
                '}';
    }
}
