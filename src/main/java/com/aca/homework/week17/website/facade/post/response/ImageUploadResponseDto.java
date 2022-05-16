package com.aca.homework.week17.website.facade.post.response;

import org.springframework.util.Assert;

import java.util.List;

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
}
