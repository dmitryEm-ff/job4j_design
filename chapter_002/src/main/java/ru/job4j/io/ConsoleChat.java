package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {

    }

    public String randomAnswer() throws IOException {
        RandomAccessFile f = new RandomAccessFile(botAnswers, "r");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1251")))) {
            final long randomLocation = (long) (Math.random() * f.length());
            f.seek(randomLocation);
            f.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f.readLine();
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat(
                "C:\\projects\\job4j_design\\chapter_002\\src\\main\\resources\\botLog.txt",
                "C:\\projects\\job4j_design\\chapter_002\\src\\main\\resources\\logic.txt"
        );
//        cc.run();
        System.out.println(cc.randomAnswer());
    }
}