package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Cleaner {
    public static Map<Path, List<Path>> search(Path root) throws IOException {
        CleanerFiles cleanerFiles = new CleanerFiles();
        Files.walkFileTree(root, cleanerFiles);
        return cleanerFiles.getPaths();
    }
}
