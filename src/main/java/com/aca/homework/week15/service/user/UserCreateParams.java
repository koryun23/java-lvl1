package com.aca.homework.week15.service.user;

import java.util.Objects;

public class UserCreateParams {
    private @NotNull
    final
    String username;

    private @NotNull
    final
    String name;

    public UserCreateParams(@NotNull String username, @NotNull String name) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(name);

        this.username = username;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("PARAMS[username=%s, name=%s]", username, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateParams that = (UserCreateParams) o;
        return username.equals(that.username) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name);
    }
}
