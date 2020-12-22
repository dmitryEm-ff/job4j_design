package ru.job4j.io;

public class FileFinderArgs {
    private static String[] args;

    public FileFinderArgs(String[] args) {
        this.args = args;
    }

    public void validation() {
        if (args.length < 4) {
            throw new IllegalArgumentException("Directory or other parameters is not entered.");
        }
    }
}
