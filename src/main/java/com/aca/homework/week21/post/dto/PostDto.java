package com.aca.homework.week21.post.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostDto {
    private LocalDateTime creationDate;
    private String content;
    private String createdBy;

    public PostDto(LocalDateTime creationDate, String content, String createdBy) {
        // TODO: ADD ASSERTIONS
        this.creationDate = creationDate;
        this.content = content;
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return Objects.equals(creationDate, postDto.creationDate) && Objects.equals(content, postDto.content) && Objects.equals(createdBy, postDto.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, content, createdBy);
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "creationDate=" + creationDate +
                ", content='" + content + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
