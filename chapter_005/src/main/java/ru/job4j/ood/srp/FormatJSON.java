package ru.job4j.ood.srp;

public class FormatJSON implements Format<String, String> {
    @Override
    public String formatter(String s) {
        return s + " - JSON Format.";
    }
}