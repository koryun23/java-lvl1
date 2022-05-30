package com.aca.homework.week21.post.dto;

import java.util.List;
import java.util.Objects;

public class UploadResponseDto {
    private List<PostDto> postDtoList;

    public UploadResponseDto(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
    }

    public List<PostDto> getPostDtoList() {
        return postDtoList;
    }

    public void setPostDtoList(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadResponseDto that = (UploadResponseDto) o;
        return Objects.equals(postDtoList, that.postDtoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postDtoList);
    }

    @Override
    public String toString() {
        return "UploadResponseDto{" +
                "postDtoList=" + postDtoList +
                '}';
    }
}
