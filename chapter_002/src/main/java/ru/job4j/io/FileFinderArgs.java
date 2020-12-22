package ru.job4j.io;

public class FileFinderArgs {
    private static String[] args;

    public FileFinderArgs(String[] args) {
        this.args = args;
    }

    public void validation() {
        if (args.length < 2) {
            throw new IllegalArgumentException("Directory or type is not entered.");
        }
    }
}
