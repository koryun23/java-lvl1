package com.aca.homework.week17.website.facade.post.request;

public class ImageUploadRequestDto {

    private final String blobId;
    private final Long postId;

    public ImageUploadRequestDto(String blobId, Long postId) {
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
