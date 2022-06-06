package com.aca.homework.week17.website.facade.post.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageDto imageDto = (ImageDto) o;
        return Objects.equals(blobId, imageDto.blobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId);
    }
}
