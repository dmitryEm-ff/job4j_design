package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void run() throws IOException {
        boolean flag = true;
        String userQuestion = "";
        Scanner scanner = new Scanner(System.in);
        List<String> arrayAnswers = Files.readAllLines(Paths.get(botAnswers), Charset.defaultCharset());
        List<String> logDialog = new ArrayList<>();
        while (!OUT.equals(userQuestion)) {
            System.out.print(System.lineSeparator() + "User : ");
            userQuestion = scanner.nextLine();
            logDialog.add("User : " + userQuestion + System.lineSeparator());
            if (STOP.equals(userQuestion)) {
                flag = false;
            }
            if (CONTINUE.equals(userQuestion)) {
                flag = true;
            }
            if (flag) {
                int random = (int) (Math.random() * arrayAnswers.size());
                String botAnswer = arrayAnswers.get(random);
                System.out.print("Bot : " + botAnswer);
                logDialog.add("Bot : " + botAnswer + System.lineSeparator());
            }
        }
        Files.write(Paths.get(path), logDialog);
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat(
                "./chapter_002/data/botLog.txt",
                "./chapter_002/data/logic.txt"
        );
        cc.run();
    }
}