package com.aca.homework.week17.website.facade.post.dto;

import java.util.List;

public class PostDto {
    private final String title;
    private final String description;
    private final List<ImageDto> imageDtos;

    public PostDto(String title, String description, List<ImageDto> imageDtos) {
        this.title = title;
        this.description = description;
        this.imageDtos = imageDtos;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<ImageDto> getImageDtos() {
        return imageDtos;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageDtos=" + imageDtos +
                '}';
    }
}
