package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String point = null;
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.contains("400") || line.contains("500")) {
                    point = "error";
                    writer.write(line.split(" ")[1] + ";");
                } else if (point != null && !line.isEmpty() && (!line.contains("400") || !line.contains("500"))) {
                    writer.write(line.split(" ")[1] + System.lineSeparator());
                    point = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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