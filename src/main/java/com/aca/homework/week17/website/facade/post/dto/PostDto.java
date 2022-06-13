package com.aca.homework.week17.website.facade.post.dto;

import java.util.List;
import java.util.Objects;

public class PostDto {
    private final String title;
    private final String description;
    private final List<ImageDto> imageDtos;
    private final UserDto ownerDto;

    public PostDto(String title, String description, List<ImageDto> imageDtos, UserDto ownerDto) {
        this.title = title;
        this.description = description;
        this.imageDtos = imageDtos;
        this.ownerDto = ownerDto;
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

    public UserDto getOwnerDto() {
        return ownerDto;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageDtos=" + imageDtos +
                ", ownerDto=" + ownerDto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto postDto = (PostDto) o;
        return Objects.equals(title, postDto.title) && Objects.equals(description, postDto.description) && Objects.equals(imageDtos, postDto.imageDtos) && Objects.equals(ownerDto, postDto.ownerDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, imageDtos, ownerDto);
    }
}
