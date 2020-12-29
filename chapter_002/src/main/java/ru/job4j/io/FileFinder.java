package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileFinder {
    private static Path rootFile;
    private static Path destFile;
    private static String fileName;

    public static List<Path> findFiles(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().contains(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void writeFiles(List<Path> pathList, Path destFile) throws IOException {
        Files.write(destFile, pathList.stream().map(Path::toString).collect(Collectors.toList()));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> parameters = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            parameters.add(reader.readLine());
            System.out.println(parameters.get(i));
        }

        FileFinderArgs ffa = new FileFinderArgs(args);
        ffa.validation();
        rootFile = Paths.get(args[1]);
        destFile = Paths.get("C:/newFolder/rsl.txt");
        fileName = args[3];
        List<Path> pathList = findFiles(rootFile, fileName);
        for (Path path : pathList) {
            System.out.println(path.toAbsolutePath());
        }
        writeFiles(pathList, destFile);
    }
}
