package ru.job4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Reader {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            Set<String> targetWords = Arrays.stream(args).collect(Collectors.toSet());
            long result = bufferedReader
                    .lines()
                    .flatMap(l -> Arrays.stream(l.split(" ")).filter(targetWords::contains))
                    .count();
            System.out.println("Found: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}