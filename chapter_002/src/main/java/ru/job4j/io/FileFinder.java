package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileFinder {
    public static List<Path> findFiles(String root, String ext, String pdt) throws IOException {

        Predicate<Path> predMask = p -> p.toFile().getName().contains(ext);
        Predicate<Path> predFull = p -> p.toFile().getName().equals(ext);
        Predicate<Path> commonPred = pdt.equals("-m") ? predMask : predFull;

        SearchFiles src = new SearchFiles(commonPred);
        Files.walkFileTree(Paths.get(root), src);
        return src.getPaths();
    }

    public static void writeFiles(List<Path> pathList, String destFile) throws IOException {
        Files.write(Paths.get(destFile), pathList.stream().map(Path::toString).collect(Collectors.toList()));
    }

    public static void main(String[] args) throws IOException {
        FileFinderArgs ffa = new FileFinderArgs(args);
        ffa.validation();

        List<Path> pathList = findFiles(args[1], args[3], args[4]);
        for (Path path : pathList) {
            System.out.println(path.toAbsolutePath());
        }
        writeFiles(pathList, args[1] + args[6]);
    }
}