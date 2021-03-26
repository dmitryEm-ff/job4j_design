package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheRealisation {
    private static final Map<String, SoftReference<String>> CACHE = new HashMap<>();

    public static String getCacheValue(String fileName) {
        String strong = null;
        SoftReference<String> soft = CACHE.get(fileName);
        if (soft == null) {
            strong = putCacheValue(fileName);
            CACHE.put(fileName, new SoftReference(strong));
        } else {
            strong = soft.get();
        }
        System.out.println(strong);
        return strong;
    }

    public static String putCacheValue(String fileName) {
        String tmp;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./chapter_004/data/" + fileName))) {
            tmp = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return tmp;
    }

    public static void main(String[] args) {
        CacheRealisation cr = new CacheRealisation();
        String addressCache = cr.getCacheValue("Address.txt");
        System.out.println(System.lineSeparator());
        String namesCache = cr.getCacheValue("Names.txt");
        System.out.println(System.lineSeparator());
        String addressCacheAgain = cr.getCacheValue("Address.txt");
        for (Map.Entry<String, SoftReference<String>> pair : CACHE.entrySet()) {
            String key = pair.getKey();
            SoftReference<String> value = pair.getValue();
            System.out.println(System.lineSeparator() + key + " : " + System.lineSeparator() + value.get());
        }
    }
}