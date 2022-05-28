package com.aca.homework.week21.post.service.core;

import java.util.Objects;

public class PostUploadRequestDto {
    private String createdBy;

    public PostUploadRequestDto(String createdBy) {
        this.createdBy = createdBy;
    }

    public PostUploadRequestDto() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostUploadRequestDto that = (PostUploadRequestDto) o;
        return Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy);
    }

    @Override
    public String toString() {
        return "PostUploadRequestDto{" +
                "createdBy='" + createdBy + '\'' +
                '}';
    }
}
