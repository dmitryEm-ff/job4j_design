package ru.job4j.gc;

public interface Cache<K, V> {

    V getCacheValue(K key);

    V readCacheValue(K key);
}