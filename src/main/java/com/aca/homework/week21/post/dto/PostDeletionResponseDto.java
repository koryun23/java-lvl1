package com.aca.homework.week21.post.dto;

import java.util.Objects;

public class PostDeletionResponseDto {
    private Long id;
    private Boolean success;

    private String error;

    public PostDeletionResponseDto(Long id, Boolean success) {
        this.id = id;
        this.success = success;
    }

    public PostDeletionResponseDto(Long id, Boolean success, String error) {
        this.id = id;
        this.success = success;
        this.error = error;
    }

    public PostDeletionResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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
        PostDeletionResponseDto that = (PostDeletionResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(success, that.success) && Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, success, error);
    }

    @Override
    public String toString() {
        return "PostDeletionResponseDto{" +
                "id=" + id +
                ", success=" + success +
                ", error=" + error +
                '}';
    }
}
