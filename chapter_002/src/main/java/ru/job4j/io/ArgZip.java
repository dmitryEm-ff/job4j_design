package ru.job4j.io;

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
        return true;
    }

    public String directory() {
        return splittedArgs.get("-d");
    }

    public String exclude() {
        return splittedArgs.get("-e");
    }

    public String output() {
        return splittedArgs.get("-o");
    }
}
