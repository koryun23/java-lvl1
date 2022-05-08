package com.aca.homework.week17.website.service.core.image;

import java.util.Objects;

public class ImageCreationParams {
    private final String blobId;
    private final Long postId;

    public ImageCreationParams(String blobId, Long postId) {
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
