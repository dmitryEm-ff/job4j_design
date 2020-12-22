package ru.job4j.io;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileFinderArgs {
    private static String[] args;

    public FileFinderArgs(String[] args) {
        this.args = args;
    }

    public void validation() {
        if (args.length < 7) {
            throw new IllegalArgumentException("Directory or other parameters is not entered.");
        }
        if (!Files.isDirectory(Paths.get(args[1]))) {
            throw  new IllegalArgumentException(String.format("Not directory %s", Paths.get(args[1])));
        }

    }
}
