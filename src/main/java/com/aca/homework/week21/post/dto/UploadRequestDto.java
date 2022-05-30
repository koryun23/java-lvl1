package com.aca.homework.week21.post.dto;

import org.springframework.util.Assert;

import java.util.Objects;

public class UploadRequestDto {

    private String createdBy;
    private long count;

    public UploadRequestDto(String createdBy, long count) {
        Assert.notNull(createdBy, "The string representing the creator of post should not be null");
        Assert.hasText(createdBy, "The string representing the creator of post should not be empty");
        this.createdBy = createdBy;
        this.count = count;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadRequestDto that = (UploadRequestDto) o;
        return count == that.count && Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, count);
    }

    @Override
    public String toString() {
        return "UploadRequestDto{" +
                "createdBy='" + createdBy + '\'' +
                ", count=" + count +
                '}';
    }
}
