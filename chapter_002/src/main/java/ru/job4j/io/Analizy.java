package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(target));
            String point = null;
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.contains("400") || line.contains("500")) {
                    point = "error";
                    writer.write(line.split(" ")[1] + ";");
                }
                if (point != null && !line.isEmpty() && (!line.contains("400") || !line.contains("500"))) {
                    writer.write(line.split(" ")[1] + System.lineSeparator());
                    point = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Analizy analizy = new Analizy();
        try (PrintWriter writer = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("server.log")))) {
            writer.write("200 10:56:01\n"
                    + "\n" + "200 10:57:01\n"
                    + "\n" + "400 10:58:01\n"
                    + "\n" + "200 10:59:01\n"
                    + "\n" + "500 11:01:02\n"
                    + "\n" + "200 11:02:02\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        analizy.unavailable("server.log", "unavailable.log");
    }
}