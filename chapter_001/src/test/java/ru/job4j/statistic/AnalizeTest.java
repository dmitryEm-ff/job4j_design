package ru.job4j.statistic;

import org.junit.Assert;
import org.junit.Test;
import static ru.job4j.statistic.Analize.Info;
import static ru.job4j.statistic.Analize.User;

import  static org.hamcrest.core.Is.is;
import  static org.junit.Assert.assertThat;
import java.util.*;

public class AnalizeTest {

    @Test
    public void whenItemsAdded() {
        List<User> previous = List.of(new User(1, "One"));
        List<User> current = List.of(new User(1, "One"), new User(2, "Two"));
        Info info = new Analize().diff(previous, current);
        Info expected = new Info(1, 0, 0);
        assertThat(info, is(expected));
    }

    @Test
    public void whenItemsChanged() {
        List<User> previous = List.of(new User(1, "One"), new User(2, "Two"));
        List<User> current = List.of(new User(1, "One"), new User(3, "Three"));
        Info info = new Analize().diff(previous, current);
        Info expected = new Info(1, 0, 1);
        assertThat(expected, is(info));
    }

    @Test
    public void whenItemsRemoved() {
        List<User> previous = List.of(new User(1, "One"), new User(2, "Two"));
        List<User> current = List.of(new User(1, "One"));
        Info info = new Analize().diff(previous, current);
        Info expected = new Info(0, 0, 1);
        assertThat(expected, is(info));
    }

    @Test
    public void whenItemsNotChanged() {
        List<User> previous = List.of(new User(1, "One"), new User(2, "Two"));
        List<User> current = List.of(new User(1, "One"), new User(2, "Two"));
        Info info = new Analize().diff(previous, current);
        Info expected = new Info(0, 0, 0);
        assertThat(expected, is(info));
    }

    @Test
    public void whenItemsChangedName() {
        List<User> previous = List.of(new User(1, "One"), new User(2, "Two"));
        List<User> current = List.of(new User(1, "One"), new User(2, "Three"));
        Info info = new Analize().diff(previous, current);
        Info expected = new Info(0, 1, 0);
        assertThat(expected, is(info));
    }
}