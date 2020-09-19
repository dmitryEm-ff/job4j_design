package ru.job4j.collection;

import java.util.*;

public class SimpleSet<E> implements Iterable<E> {

    private SimpleArray<E> array = new SimpleArray<>();

    public E get(int index) {
        return array.get(index);
    }

    public void add(E model) {
        array.add(model);
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}