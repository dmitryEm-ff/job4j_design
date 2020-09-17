package ru.job4j.collection;

import java.util.NoSuchElementException;
import java.util.Optional;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.pushLast(in.popLast());
            }
        }
        return out.popLast();
    }

    public void push(T value) {
        in.pushLast(value);
    }
}
