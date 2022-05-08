package com.aca.homework.week17.website.facade.post.response;

public class ImageUploadResponseDto {
    private final String blobId;
    private final Long postId;

    public ImageUploadResponseDto(String blobId, Long postId) {
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
        return "ImageUploadResponseDto{" +
                "blobId='" + blobId + '\'' +
                ", postId=" + postId +
                '}';
    }
}
