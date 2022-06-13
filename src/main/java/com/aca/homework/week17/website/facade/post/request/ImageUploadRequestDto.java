package com.aca.homework.week17.website.facade.post.request;

import org.springframework.util.Assert;

public class ImageUploadRequestDto {

    private final String blobId;
    private final Long postId;

    public ImageUploadRequestDto(String blobId, Long postId) {
        Assert.notNull(blobId, "blob id should not be null");
        Assert.hasText(blobId, "blob id should not be empty");
        Assert.notNull(postId, "post id should not be null");
        this.blobId = blobId;
        this.postId = postId;
    }

    public String getBlobId() {
        return blobId;
    }

    public Long getPostId() {
        return postId;
    }

    @Override
    public String toString() {
        return "ImageUploadRequestDto{" +
                "blobId='" + blobId + '\'' +
                ", postId=" + postId +
                '}';
    }
}
