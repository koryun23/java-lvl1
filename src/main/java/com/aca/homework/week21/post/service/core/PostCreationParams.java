package com.aca.homework.week21.post.service.core;

import java.util.Objects;

public class PostCreationParams {
    private String createdBy;

    public PostCreationParams(String createdBy) {
        this.createdBy = createdBy;
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
        PostCreationParams that = (PostCreationParams) o;
        return Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy);
    }

    @Override
    public String toString() {
        return "PostCreationParams{" +
                "createdBy='" + createdBy + '\'' +
                '}';
    }
}
