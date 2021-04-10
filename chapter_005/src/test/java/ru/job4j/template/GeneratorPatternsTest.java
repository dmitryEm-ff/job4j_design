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

    @Test
    public void whenTemplateHaveDiffArgs() {
        String template = "I am a ${person}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        boolean result = false;
        try {
            String out = new GeneratorPatterns().produce(template, args);
        } catch (Exception e) {
            result = true;
        } finally {
            assertThat(result, is(true));
        }
    }

    @Test
    public void whenHaveMoreArgs() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("profession", "worker");
        boolean result = false;
        try {
            String out = new GeneratorPatterns().produce(template, args);
        } catch (Exception e) {
            result = true;
        } finally {
            assertThat(result, is(true));
        }
    }




//    @Test(expected = IllegalArgumentException.class)
//    public void whenNotContains() {
//        Map<String, String> args = new HashMap<>();
//        args.put("name", "Igor");
//        args.put("subject", "you");
//
//        String template = "Petr Arsentev";
//        GeneratorPatterns testGen = new GeneratorPatterns();
//        testGen.produce(template, args);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void whenExcess() {
//        Map<String, String> args = new HashMap<>();
//        args.put("name", "Igor");
//        args.put("subject", "you");
//
//        args.get("year");
//    }
}