package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Entry> {

    private Entry<K, V>[] table;
    private final float loadFactor = 0.75f;
    private final float capacity = 16f;
    private int threshold;
    private int size;
    private int modCount;

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

    private void resize() {
        Entry<K, V>[] oldTable = table;
        int newLength = oldTable.length * 2;
        threshold = (int) (newLength * loadFactor);
        Entry<K, V>[] newTable = new Entry[newLength];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                newTable[oldTable[i].hash] = oldTable[i];
            }
        }
        table = newTable;
    }

    public boolean insert(K key, V value) {
        if (key == null) {
            return false;
        }
        if (size + 1 >= threshold) {
            resize();
        }
        int h = hash(key.hashCode());
        int index = indexFor(h, table.length);
        Entry<K, V> element = table[index];
        if (table[index] != null && element.hash == h && (element.key == key || key.equals(element.key))) {
            return false;
        }
        table[index] = new Entry<>(key, value, h);
        modCount++;
        size++;
        return true;
    }

    public V get(K key) {
        int index = indexFor(hash(key.hashCode()), table.length);
        if (table[index] == null) {
            return null;
        }
        return table[index].value;
    }

    public boolean delete(K key) {
        if (key == null) {
            return false;
        }
        int index = indexFor(hash(key.hashCode()), table.length);
        if (table[index] == null) {
            return false;
        }
        table[index] = null;
        modCount++;
        size--;
        return true;
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<Entry>() {

            private int expectedModCount  = modCount;
            private int cursor;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[cursor] != null;
            }

            @Override
            public Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++];
            }
        };
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
