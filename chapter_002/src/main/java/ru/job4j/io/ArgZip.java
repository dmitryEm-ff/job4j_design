package ru.job4j.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArgZip {

    private final String[] args;
    private ArgsName splittedArgs;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 3) {
            throw new IllegalArgumentException("Not enough arguments!");
        }
        splittedArgs = ArgsName.of(args);

        if (!Files.exists(Paths.get(directory()))) {
            throw new IllegalArgumentException("This directory doesnt exist!");
        }
        if (!Files.isDirectory(Paths.get(directory()))) {
            throw new IllegalArgumentException("Invalid catalog!");
        }
        return true;
    }

    public String directory() {
        return splittedArgs.get("d");
    }

    public String exclude() {
        return splittedArgs.get("e");
    }

    public String output() {
        return splittedArgs.get("o");
    }
}
