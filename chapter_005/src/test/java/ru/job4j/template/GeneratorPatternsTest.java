package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneratorPatternsTest {

    @Test
    public void whenCorrectTemplates() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        GeneratorPatterns testGen = new GeneratorPatterns();
        String out = testGen.produce(template, args);
        assertThat(out, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateHaveDiffArgs() {
        String template = "I am a ${person}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        GeneratorPatterns testGen = new GeneratorPatterns();
        String out = testGen.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenHaveMoreArgs() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("profession", "worker");
        GeneratorPatterns testGen = new GeneratorPatterns();
        String out = testGen.produce(template, args);
    }
}