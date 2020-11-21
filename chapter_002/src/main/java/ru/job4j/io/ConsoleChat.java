package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        boolean flag = true;
        List<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (!OUT.equals(scanner.nextLine())) {
            
        }
    }

    public String randomAnswer() throws IOException {
        RandomAccessFile f = new RandomAccessFile(botAnswers, "r");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
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
                "./chapter_002/data/botLog.txt",
                "./chapter_002/data/logic.txt"
        );
//        cc.run();
        System.out.println(cc.randomAnswer());
    }
}