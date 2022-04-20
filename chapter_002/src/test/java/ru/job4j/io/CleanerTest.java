package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CleanerTest {

    @Test
    public void whenDuplicateExist() throws IOException {
        /*
        Path file1 = Paths.get("./src/main/resources/test.txt");
        Files.write(file1, List.of("Some text"));
        Files.copy(file1, Paths.get("./src/main/java/ru/job4j/test.txt"), StandardCopyOption.REPLACE_EXISTING);
        Path start = Paths.get("./src/main");

        List<Path> rsl = Cleaner.search(start);
        List<Path> expected = List.of(Paths.get("./src/main/resources/test.txt").toAbsolutePath());
        assertThat(rsl.stream().map(Path::toAbsolutePath).collect(Collectors.toList()), is(expected));

         */
    }
}