package com.aca.homework.week17.website.facade.post.request;

import java.util.List;

public class PostCreationRequestDto {
    private final String title;

    private final String description;

    private final Long userId;

    private final List<ImageUploadRequestDto> imageUploadRequestDtos;

    public PostCreationRequestDto(String title, String description, Long userId, List<ImageUploadRequestDto> imageIds) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.imageUploadRequestDtos = imageIds;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }

    public List<ImageUploadRequestDto> getImageUploadRequestDtos() {
        return imageUploadRequestDtos;
    }

    @Override
    public String toString() {
        return "PostCreationRequestDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", imageUploadRequestDtos=" + imageUploadRequestDtos +
                '}';
    }
}
