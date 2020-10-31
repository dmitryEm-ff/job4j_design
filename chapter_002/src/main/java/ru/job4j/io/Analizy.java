package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String point = null;
            while (reader.ready()) {
                String line = reader.readLine();
                if ((line.contains("400") || line.contains("500")) && point == null) {
                    point = "error";
                    list.add(line.split(" ")[1] + ";");
                } else if (point != null && !line.isEmpty() && !line.contains("400") && !line.contains("500")) {
                    list.add(line.split(" ")[1] + System.lineSeparator());
                    point = null;
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (String s : list) {
                writer.write(s);
            }
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}