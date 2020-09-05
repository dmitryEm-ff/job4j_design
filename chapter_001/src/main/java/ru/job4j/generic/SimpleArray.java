package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.apache.commons.lang.ArrayUtils;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, this.index);
        this.objects[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, this.index);
        ArrayUtils.removeElement(this.objects, index);
        this.index--;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) this.objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < index && objects[index] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[currentIndex++];
            }
        };
    }
}