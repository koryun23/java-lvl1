package com.aca.homework.week17.website.facade.post.request;

import org.springframework.util.Assert;

import java.util.List;

public class PostCreationRequestDto {
    private final String title;

    private final String description;

    private final Long userId;

    private final List<ImageUploadRequestDto> imageUploadRequestDtos;

    public PostCreationRequestDto(String title, String description, Long userId, List<ImageUploadRequestDto> imageIds) {
        Assert.notNull(title, "title should not be null");
        Assert.hasText(title, "title should not be empty");
        Assert.notNull(description, "description should not be null");
        Assert.hasText(description, "description should not be empty");
        Assert.notNull(userId, "user id should not be null");
        Assert.notNull(imageIds, "image ids should not be null");
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
