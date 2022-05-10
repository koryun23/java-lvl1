package com.aca.homework.week17.website.facade.post.response;

import java.time.LocalDateTime;
import java.util.List;

public class PostCreationResponseDto {

    private List<ImageUploadResponseDto> imageDtos;
    private String title;
    private String description;
    private LocalDateTime creationDate;

    private List<String> errors;

    public PostCreationResponseDto(List<ImageUploadResponseDto> images, String title, String description, LocalDateTime creationDate) {
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
