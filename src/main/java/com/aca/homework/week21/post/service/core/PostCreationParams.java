package com.aca.homework.week21.post.service.core;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostCreationParams {
    private LocalDateTime creationDate;
    private String content;
    private String createdBy;

    public PostCreationParams(LocalDateTime creationDate, String content, String createdBy) {
        //TODO: ADD ASSERTIONS
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
        PostCreationParams that = (PostCreationParams) o;
        return Objects.equals(creationDate, that.creationDate) && Objects.equals(content, that.content) && Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, content, createdBy);
    }

    @Override
    public String toString() {
        return "PostCreationParams{" +
                "creationDate=" + creationDate +
                ", content='" + content + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
