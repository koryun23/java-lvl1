package com.aca.homework.week21.post.dto;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.time.LocalDateTime;
import java.util.Objects;

public class SinglePostRetrievalDto {
    private PostDto postDto;

    private String error;

    public SinglePostRetrievalDto(PostDto postDto) {
        this.postDto = postDto;
    }

    public SinglePostRetrievalDto(String error) {
        this.error = error;
    }

    public SinglePostRetrievalDto() {
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
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
        SinglePostRetrievalDto that = (SinglePostRetrievalDto) o;
        return Objects.equals(postDto, that.postDto) && Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postDto, error);
    }

    @Override
    public String toString() {
        return "SinglePostRetrievalDto{" +
                "postDto=" + postDto +
                ", error='" + error + '\'' +
                '}';
    }
}
