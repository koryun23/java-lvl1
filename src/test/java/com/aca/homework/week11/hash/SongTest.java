package com.aca.homework.week11.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SongTest {
    @Test
    public void testEqualsAndHashCodeWhen2SongsAreTheSame(){
        Song song1 = new Song(new Singer("a", "b"), "name", 300, 5);
        Song song2 = new Song(new Singer("a", "b"), "name", 300, 5);
        Assertions.assertEquals(song1, song2);
        Assertions.assertEquals(song1.hashCode(), song2.hashCode());
    }

    @Test
    public void testEqualsWHen2SongsAreNotTheSame(){
        Song song1 = new Song(new Singer("a", "b"), "name", 300, 5);
        Song song2 = new Song(new Singer("c", "b"), "another name", 310, 5);
        Assertions.assertNotEquals(song1, song2);
    }
}