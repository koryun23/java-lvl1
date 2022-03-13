package com.aca.homework.week10.entry;

public class EntryImpl<K, V> implements Entry<K, V> {
    private final K key;
    private final V value;

    public EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K key() {
        return key;
    }

    public V value() {
        return value;
    }
}
