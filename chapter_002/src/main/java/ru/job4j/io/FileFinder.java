package ru.job4j.io;

import java.nio.file.Files;

public class FileFinder {
    public static void main(String[] args) {
        FileFinderArgs fileFinderArgs = new FileFinderArgs(args);
        fileFinderArgs.validation();

    }
}