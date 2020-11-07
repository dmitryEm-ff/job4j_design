package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Cleaner {
    public static List<Path> search(Path root) throws IOException {
        CleanerFiles cleanerFiles = new CleanerFiles();
        Files.walkFileTree(root, cleanerFiles);
        return cleanerFiles.getDublicates();
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:/projects/job4j_design/chapter_002");
        search(start).forEach(System.out::println);
    }
}
