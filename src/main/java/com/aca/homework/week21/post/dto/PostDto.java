package com.aca.homework.week21.post.dto;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostDto {
    private LocalDateTime creationDate;
    private String catFactContent;
    private String createdBy;

    public PostDto(LocalDateTime creationDate, String catFactContent, String createdBy) {
        Assert.notNull(creationDate, "Creation date should not be null");
        Assert.notNull(catFactContent, "Cat fact content should not be null");
        Assert.hasText(catFactContent, "Cat fact content should not be empty");
        Assert.notNull(createdBy, "The string representing the author of the post should not be null");
        Assert.hasText(createdBy, "The string representing the author of the post should not be empty");
        this.creationDate = creationDate;
        this.catFactContent = catFactContent;
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getCatFactContent() {
        return catFactContent;
    }

    public void setCatFactContent(String catFactContent) {
        this.catFactContent = catFactContent;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto postDto = (PostDto) o;
        return Objects.equals(creationDate, postDto.creationDate) && Objects.equals(catFactContent, postDto.catFactContent) && Objects.equals(createdBy, postDto.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, catFactContent, createdBy);
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "creationDate=" + creationDate +
                ", catFactContent='" + catFactContent + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
