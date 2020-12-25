package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileFinder {
//    private static Path searchFile;
//    private static Path rootFile;
//
//    public FileFinder(Path rootFile, Path searchFile) {
//        this.rootFile = rootFile;
//        this.searchFile = searchFile;
//    }

    public static List<Path> findFiles(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().contains(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        FileFinderArgs fileFinderArgs = new FileFinderArgs(args);
        fileFinderArgs.validation();
        List<Path> pathList = findFiles(Paths.get(args[1]), args[3]);
    }
}