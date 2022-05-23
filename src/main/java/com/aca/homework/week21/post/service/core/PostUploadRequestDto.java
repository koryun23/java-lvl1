package com.aca.homework.week21.post.service.core;

import com.aca.homework.week21.post.CatFactDto;

import java.time.LocalDateTime;

public class PostUploadRequestDto {
    private LocalDateTime creationDate;
    private CatFactDto catFactDto;
    private String createdBy;

    public PostUploadRequestDto(LocalDateTime creationDate, CatFactDto catFactDto, String createdBy) {
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
