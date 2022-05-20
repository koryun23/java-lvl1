package com.aca.homework.week17.note.facade.note;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public class NoteCreationResponseDto {
    private final String username;
    private final String text;
    private final LocalDate creationDate;

    public NoteCreationResponseDto(String username, String text, LocalDate creationDate) {
        Assert.notNull(username, "username should not be null");
        Assert.notNull(text, "text should not be null");
        Assert.notNull(creationDate, "creation date should not be null");
        this.username = username;
        this.text = text;
        this.creationDate = creationDate;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteCreationResponseDto that = (NoteCreationResponseDto) o;
        return Objects.equals(username, that.username) && Objects.equals(text, that.text) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, text, creationDate);
    }

    @Override
    public String toString() {
        return "NoteCreationResponseDto{" +
                "username='" + username + '\'' +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
