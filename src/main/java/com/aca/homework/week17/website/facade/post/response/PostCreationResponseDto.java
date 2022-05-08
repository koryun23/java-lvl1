package com.aca.homework.week17.website.facade.post.response;

import java.time.LocalDateTime;
import java.util.List;

public class PostCreationResponseDto {

    private final List<ImageUploadResponseDto> imageDtos;
    private final String title;
    private final String description;
    private final LocalDateTime creationDate;

    public PostCreationResponseDto(List<ImageUploadResponseDto> images, String title, String description, LocalDateTime creationDate) {
        this.imageDtos = images;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
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
                '}';
    }
}
