package ru.job4j.collection;

import java.util.*;

public class SimpleSet<E> implements Iterable<E> {

    private SimpleArray<E> array = new SimpleArray<>();

    public void add(E model) {
        for (E e : array) {
            if (!Objects.equals(e, model)) {
                array.add(model);
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}