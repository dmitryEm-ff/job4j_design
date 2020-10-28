package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class AnalizyTest {

    @Test
    public void whenWriteFromServerLog() {
        File source = Analizy.class.getResource("server.log");
        File target = Analizy.class.getResource("unavailable.log");
    }
}