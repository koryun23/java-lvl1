package com.aca.homework.week17.website.service.core.post;

import org.springframework.util.Assert;

import java.util.Objects;

public final class PostCreationParams {
    private final String title;

    private final String description;

    private final Long userId;

    public PostCreationParams(String title, String description, Long userId) {
        Assert.notNull(title, "title should not be null");
        Assert.notNull(description, "description should not be null");
        Assert.notNull(userId, "user id should not be null");
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCreationParams that = (PostCreationParams) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, userId);
    }

    @Override
    public String toString() {
        return "PostCreationParams{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
