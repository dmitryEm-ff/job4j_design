package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CleanerTest {

    @Test
    public void whenDuplicateExist() throws IOException {
        File file1 = new File("./src/main/resources/test.txt");
        File file2 = new File("./src/main/test.txt");
        Path start = Paths.get("./src/main");

        List<Path> rsl = Cleaner.search(start);
        List<Path> expected = List.of(Paths.get("test.txt"));
        assertThat(rsl, is(expected));
    }
}