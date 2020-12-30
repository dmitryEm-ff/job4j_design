package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileFinder {
    public static List<Path> findFiles(String root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().contains(ext));
        Files.walkFileTree(Paths.get(root), searcher);
        return searcher.getPaths();
    }

    public static void writeFiles(List<Path> pathList, String destFile) throws IOException {
        Files.write(Paths.get(destFile), pathList.stream().map(Path::toString).collect(Collectors.toList()));
    }

    public static void main(String[] args) throws IOException {
        FileFinderArgs ffa = new FileFinderArgs(args);
        ffa.validation();

        List<Path> pathList = findFiles(args[1], args[3]);
        for (Path path : pathList) {
            System.out.println(path.toAbsolutePath());
        }
        writeFiles(pathList, args[1] + args[6]);
    }
}