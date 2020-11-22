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
        String userQuestion = "";
        String botAnswer;
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            while (!OUT.equals(userQuestion)) {
                userQuestion = scanner.nextLine();
                bufferedWriter.write(userQuestion + System.lineSeparator());
                if (STOP.equals(userQuestion)) {
                    flag = false;
                }
                if (CONTINUE.equals(userQuestion)) {
                    flag = true;
                }
                if (flag) {
                    botAnswer = randomAnswer();
                    System.out.println(botAnswer);
                    bufferedWriter.write(botAnswer + System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String randomAnswer() throws IOException {
        RandomAccessFile f = new RandomAccessFile(botAnswers, "r");
        final long randomLocation = (long) (Math.random() * f.length());
        f.seek(randomLocation);
        return f.readLine();
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat(
                "./chapter_002/data/botLog.txt",
                "./chapter_002/data/logic.txt"
        );
        cc.run();
//        System.out.println(cc.randomAnswer());
    }
}