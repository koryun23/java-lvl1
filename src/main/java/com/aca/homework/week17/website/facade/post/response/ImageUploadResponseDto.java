package com.aca.homework.week17.website.facade.post.response;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public class ImageUploadResponseDto {
    private String blobId;
    private Long postId;

    private List<String> errors;

    public ImageUploadResponseDto(String blobId, Long postId) {
        Assert.notNull(blobId, "blob id should not be null");
        Assert.hasText(blobId, "blob id should not be empty");
        Assert.notNull(postId, "post id should not be null");
        this.blobId = blobId;
        this.postId = postId;
    }

    public ImageUploadResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public String getBlobId() {
        return blobId;
    }

    public Long getPostId() {
        return postId;
    }

    @Override
    public String toString() {
        return "ImageUploadResponseDto{" +
                "blobId='" + blobId + '\'' +
                ", postId=" + postId +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageUploadResponseDto that = (ImageUploadResponseDto) o;
        return Objects.equals(blobId, that.blobId) && Objects.equals(postId, that.postId) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId, postId, errors);
    }
}
