package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CacheRealisation {
    private final Map<String, Path> cache = new HashMap<>();

    public void readFromCache(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/data/" + fileName))) {
            if (!cache.containsKey(fileName)) {
                cache.put(fileName, Paths.get(fileName));
            }

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
