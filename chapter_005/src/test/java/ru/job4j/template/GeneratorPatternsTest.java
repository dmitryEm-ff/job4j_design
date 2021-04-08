package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneratorPatternsTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNotContains() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Igor");
        args.put("subject", "you");

        String template = "Petr Arsentev";
        GeneratorPatterns testGen = new GeneratorPatterns();
        testGen.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExcess() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Igor");
        args.put("subject", "you");

        args.get("year");
    }
}