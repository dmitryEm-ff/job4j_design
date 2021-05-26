package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIfFilterMoreThan2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        ListUtils.removeIf(input, x -> x > 2);
        assertThat(input, is(Arrays.asList(0, 1, 2)));
    }

    @Test
    public void whenReplaceIfFilterOdd99() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 4, 5, 6, 4));
        ListUtils.replaceIf(input, x -> x % 2 == 0, 99);
        assertThat(input, is(Arrays.asList(99, 1, 99, 99, 99, 5, 99, 99)));
    }

    @Test
    public void whenRemoveAllFromElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> elements = new ArrayList<>(Arrays.asList(5, 3, 8));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Arrays.asList(0, 1, 2, 4, 6, 7)));
    }
}