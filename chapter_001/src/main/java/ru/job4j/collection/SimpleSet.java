package ru.job4j.collection;

import java.util.*;

public class SimpleSet<E> implements Iterable<E> {

    private SimpleArray<E> array = new SimpleArray<>();

    public void add(E model) {
        if (!contains(model)) {
            array.add(model);
        }
    }

    public boolean contains(E model) {
        boolean rsl = false;
        for (E e : array) {
            if (Objects.equals(e, model)) {
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }

    public int size() {
        return array.size();
    }
}