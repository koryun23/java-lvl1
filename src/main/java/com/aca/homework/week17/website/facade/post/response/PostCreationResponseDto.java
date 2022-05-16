package com.aca.homework.week17.website.facade.post.response;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

public class PostCreationResponseDto {

    private List<ImageUploadResponseDto> imageDtos;
    private String title;
    private String description;
    private LocalDateTime creationDate;

    private List<String> errors;

    public PostCreationResponseDto(List<ImageUploadResponseDto> images, String title, String description, LocalDateTime creationDate) {
        Assert.notNull(images, "image upload response dto list should not be null");
        Assert.notNull(title, "title should not be null");
        Assert.hasText(title, "title should not be empty");
        Assert.notNull(description, "description should not be null");
        Assert.hasText(description, "description should not be empty");
        Assert.notNull(creationDate, "creation date should not be null");
        this.imageDtos = images;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    public PostCreationResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public List<ImageUploadResponseDto> getImageDtos() {
        return imageDtos;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "PostCreationResponseDto{" +
                "imageDtos=" + imageDtos +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", errors=" + errors +
                '}';
    }
}
