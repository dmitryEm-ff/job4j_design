package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private int modCount;
    private int elemCount;
    private Object[] container = new Object[10];

    public T get(int index) {
        Objects.checkIndex(index, elemCount);
        return (T) container[index];
    }

    public void add(T model) {
        if (elemCount == container.length - 1) {
            container = Arrays.copyOf(container, (container.length * 3) / 2 + 1);
        }
        container[elemCount] = model;
        modCount++;
        elemCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int expectedModCount  = modCount;
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentIndex < elemCount;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[currentIndex++];
            }
        };
    }

    public int size() {
        return elemCount;
    }
}
