package com.aca.homework.week21.post.facade;

import com.aca.homework.week21.post.CatFactDto;

import java.time.LocalDateTime;

public class PostDto {
    private LocalDateTime creationDate;
    private CatFactDto catFactDto;
    private String createdBy;

    public PostDto(LocalDateTime creationDate, CatFactDto catFactDto, String createdBy) {
        this.creationDate = creationDate;
        this.catFactDto = catFactDto;
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public CatFactDto getCatFactDto() {
        return catFactDto;
    }

    public void setCatFactDto(CatFactDto catFactDto) {
        this.catFactDto = catFactDto;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
