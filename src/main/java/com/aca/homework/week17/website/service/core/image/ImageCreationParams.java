package com.aca.homework.week17.website.service.core.image;

import org.springframework.util.Assert;

import java.util.Objects;

public final class ImageCreationParams {
    private final String blobId;
    private final Long postId;

    public ImageCreationParams(String blobId, Long postId) {
        Assert.notNull(blobId, "blob id should not be null");
        Assert.hasText(blobId, "blobid should not be empty");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageCreationParams that = (ImageCreationParams) o;
        return Objects.equals(blobId, that.blobId) && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId, postId);
    }

    @Override
    public String toString() {
        return "ImageCreationParams{" +
                "blobId=" + blobId +
                "postId=" + postId +
                '}';
    }
}
