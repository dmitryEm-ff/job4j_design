package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheRealisation {
    private static final Map<String, SoftReference<String>> CACHE = new HashMap<>();

    public void getCacheValue(String fileName) {
        if (!CACHE.containsKey(fileName)) {
            CACHE.put(fileName, putCacheValue(fileName));
        }
        System.out.println(CACHE.get(fileName));
    }

    public SoftReference<String> putCacheValue(String fileName) {
        String tmp;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./chapter_004/data/" + fileName))) {
            tmp = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return new SoftReference<String>(tmp);
    }

    public static void main(String[] args) {
        CacheRealisation cr = new CacheRealisation();
        cr.getCacheValue("Address.txt");
        System.out.println(System.lineSeparator());
        cr.getCacheValue("Names.txt");
        for (Map.Entry<String, SoftReference<String>> pair : CACHE.entrySet()) {
            String key = pair.getKey();
            SoftReference<String> value = pair.getValue();
            System.out.println(System.lineSeparator() + key + " : " + System.lineSeparator() + value);
        }
    }
}