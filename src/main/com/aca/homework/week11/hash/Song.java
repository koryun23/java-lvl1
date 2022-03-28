package com.aca.homework.week11.hash;

import java.util.Objects;

public class Song {
    private final Singer singer;
    private final String name;
    private final long duration;
    private final float rating;

    public Song(Singer singer, String name, long duration, float rating) {
        this.singer = singer;
        this.name = name;
        this.duration = duration;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return duration == song.duration && Float.compare(song.rating, rating) == 0 && Objects.equals(singer, song.singer) && Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(duration);
        result = 31 * result + Float.hashCode(rating);
        result = 31 * result + name.hashCode();
        result = 31 * result + singer.hashCode();
        return result;
    }
}
