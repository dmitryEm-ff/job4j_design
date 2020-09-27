package ru.job4j.collection;

import java.util.Iterator;

public class SimpleHashMap<K, V> implements Iterable {

    private Entry<K, V>[] table;
    private final float loadFactor = 0.75f;
    private final float capacity = 16f;
    private int threshold;
    private int size;
    private int modCount;
    private int h;

    public SimpleHashMap(Entry<K, V>[] table, int threshold, int size) {
        this.table = new Entry[(int) capacity];
        this.threshold = (int) (capacity * loadFactor);
        this.size = 0;
        this.modCount = 0;
    }

    public int size() {
        return this.size;
    }

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public boolean insert(K key, V value) {
        return false;
    }

    public V get(K key) {
        return null;
    }

    public boolean delete(K key) {
        return false;
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
