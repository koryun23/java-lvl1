package com.aca.homework.week10.concrete.map;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<Bucket<String, String>> objects = new ArrayList<>();

    public void put(@NotNull String key, @NotNull String value) {
        if(key == null)
            throw new IllegalArgumentException("Key must be non-null");
        if(value == null)
            throw new IllegalArgumentException("Value must be non-null");
        Bucket<String, String> existingBucket = existingBucket(key);
        if (existingBucket != null) {
            existingBucket.setValue(value);
            return;
        }
        Bucket<String, String> bucket = new Bucket<>(key, value);
        objects.add(bucket);
    }

    public String getValue(String key) {
        if(key == null)
            return null;
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getKey().equals(key)) {
                return objects.get(i).getValue();
            }
        }
        return null;
    }

    public int size() {
        return objects.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Bucket<String, String> existingBucket(String key) {
        for (Bucket<String, String> object : objects) {
            if (object.getKey().equals(key)) {
                return object;
            }
        }
        return null;
    }
}
