package ru.job4j.ood.srp;

public class FormatHTML implements Format<String, String> {
    @Override
    public String formatter(String s) {
        return s + " - HTML Format.";
    }
}