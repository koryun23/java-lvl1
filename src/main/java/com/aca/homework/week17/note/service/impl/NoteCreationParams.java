package com.aca.homework.week17.note.service.impl;

import com.aca.homework.week17.note.entity.User;

import java.time.LocalDate;
import java.util.Objects;

public class NoteCreationParams {
    private final User user;

    private final String text;

    private final LocalDate creationDate;

    public NoteCreationParams(User user, String text, LocalDate creationDate) {
        this.user = user;
        this.text = text;
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
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
        NoteCreationParams that = (NoteCreationParams) o;
        return Objects.equals(user, that.user) && Objects.equals(text, that.text) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, text, creationDate);
    }

    @Override
    public String toString() {
        return "NoteCreationParams{" +
                "user=" + user +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
