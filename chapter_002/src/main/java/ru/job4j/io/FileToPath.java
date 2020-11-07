package ru.job4j.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileToPath {
    public static void main(String[] args) {
        File file = new File("/home/alex/java-lessons.ru/test.txt");
        Path path = file.toPath();
        Path path2 = Paths.get("/home/alex/java-lessons.ru/test.txt");
        File file2 = path2.toFile();
    }
}