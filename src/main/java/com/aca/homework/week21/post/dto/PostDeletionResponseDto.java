package com.aca.homework.week21.post.dto;

import java.util.List;
import java.util.Objects;

public class PostDeletionResponseDto {

    private Long id;
    private Boolean success;

    private List<String> errors;

    public PostDeletionResponseDto(Long id, Boolean success) {
        this.id = id;
        this.success = success;
    }

    public PostDeletionResponseDto(Long id, Boolean success, List<String> errors) {
        this.id = id;
        this.success = success;
        this.errors = errors;
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
        PostDeletionResponseDto that = (PostDeletionResponseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(success, that.success) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, success, errors);
    }

    @Override
    public String toString() {
        return "PostDeletionResponseDto{" +
                "id=" + id +
                ", success=" + success +
                ", errors=" + errors +
                '}';
    }
}
