package com.aca.homework.week21.post.service.core;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostCreationParams {

    private String createdBy;
    private LocalDateTime creationDate;
    private String fact;

    public PostCreationParams(LocalDateTime creationDate, String fact, String createdBy) {
        Assert.notNull(creationDate, "Creation date should not be null");
        Assert.notNull(fact, "Cat fact content should not be null");
        Assert.hasText(fact, "Cat fact content should not be empty");
        Assert.notNull(createdBy, "The string representing the author of the post should not be null");
        Assert.hasText(createdBy, "The string representing the author of the post should not be empty");
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.fact = fact;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    @Override
    public String toString() {
        return "PostCreationParams{" +
                "createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", fact=" + fact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCreationParams that = (PostCreationParams) o;
        return Objects.equals(createdBy, that.createdBy) && Objects.equals(creationDate, that.creationDate) && Objects.equals(fact, that.fact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, creationDate, fact);
    }
}
