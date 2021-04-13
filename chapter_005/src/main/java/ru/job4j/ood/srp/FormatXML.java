package ru.job4j.ood.srp;

public class FormatXML implements Format<String, String> {
    @Override
    public String formatter(String s) {
        return s + " - XML Format.";
    }
}