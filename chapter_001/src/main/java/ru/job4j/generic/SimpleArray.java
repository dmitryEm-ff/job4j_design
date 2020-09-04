package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import org.apache.commons.lang.ArrayUtils;

public class SimpleArray<T> implements Iterable<T> {

    Object[] objects;
    int index = 0;

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
        //todo
        Objects.checkIndex(index, this.index);
        return (T) this.objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}