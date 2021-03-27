package ru.job4j.gc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheRealisation implements Cache<String, String> {
    private final Map<String, SoftReference<String>> cacheMap = new HashMap<>();
    private static final Logger LOG = LoggerFactory.getLogger(CacheRealisation.class.getName());

    @Override
    public String getCacheValue(String fileName) {
        String strong = "";
        if (cacheMap.containsKey(fileName)) {
            strong = cacheMap.get(fileName).get();
        }
        if (strong == null || strong.length() == 0 || !cacheMap.containsKey(fileName)) {
            strong = readCacheValue(fileName);
            cacheMap.put(fileName, new SoftReference<>(strong));
        }
        System.out.println(strong);
        return strong;
    }

    @Override
    public String readCacheValue(String fileName) {
        String tmp = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./chapter_004/data/" + fileName))) {
            tmp = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
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
        for (Map.Entry<String, SoftReference<String>> pair : cr.cacheMap.entrySet()) {
            String key = pair.getKey();
            SoftReference<String> value = pair.getValue();
            System.out.println(System.lineSeparator() + key + " : " + System.lineSeparator() + value.get());
        }
    }
}