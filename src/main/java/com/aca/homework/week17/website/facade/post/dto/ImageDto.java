package com.aca.homework.week17.website.facade.post.dto;

public class ImageDto {
    private final String blobId;

    public ImageDto(String blobId) {
        this.blobId = blobId;
    }

    public String getBlobId() {
        return blobId;
    }

    @Override
    public String toString() {
        return "ImageDto{" +
                "blobId='" + blobId + '\'' +
                '}';
    }
}
