package ru.job4j.collection;

import java.util.Iterator;

public class SimpleHashMap<K, V> implements Iterable {

    private Entry<K, V>[] table;
    private final float loadFactor = 0.75f;
    private final float capacity = 16f;
    private int threshold;
    private int size;
    private int modCount;

    public boolean insert(K key, V value) {

    }

    public V get(K key) {

    }

    public boolean delete(K key) {

    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static class Entry<K, V> {
        private K key;
        private V value;
        private int hash;

        public Entry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
