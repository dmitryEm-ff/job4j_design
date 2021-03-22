package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CacheRealisation {
    private static final Map<SoftReference<String>, SoftReference<Path>> CACHE = new HashMap<>();

    public void readFromCache(String fileName) {
        if (!CACHE.containsKey(fileName)) {
            CACHE.put(new SoftReference(fileName), new SoftReference(Paths.get("./chapter_004/data/" + fileName)));
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./chapter_004/data/" + fileName))) {
            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        CacheRealisation cr = new CacheRealisation();
        cr.readFromCache("Address.txt");
        System.out.println(System.lineSeparator());
        cr.readFromCache("Names.txt");
        System.out.println(System.lineSeparator());
        for (Map.Entry<SoftReference<String>, SoftReference<Path>> pair : CACHE.entrySet()) {
            SoftReference<String> key = pair.getKey();
            SoftReference<Path> value = pair.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
