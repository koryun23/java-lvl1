package com.aca.homework.week21.post.dto;

import java.time.LocalDateTime;

public class PostDto {
    private LocalDateTime creationDate;
    private String catFactContent;
    private String createdBy;

    public PostDto(LocalDateTime creationDate, String catFactContent, String createdBy) {
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
}
