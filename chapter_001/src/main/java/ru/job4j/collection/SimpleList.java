package ru.job4j.collection;

import java.util.*;

public class SimpleList<E> implements Iterable<E> {

    private int modCount;
    private int elemCount;
    private Object[] container = new Object[10];
    private Node<E> first;
    private Node<E> last;

    public E get(int index) {
        Objects.checkIndex(index, elemCount);
        return (E) container[index];
    }

    public void add(E value) {
        if (elemCount == container.length - 1) {
            container = Arrays.copyOf(container, (container.length * 3) / 2 + 1);
        }
        container[elemCount] = value;
        modCount++;
        elemCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

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
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[currentIndex++];
            }
        };
    }
}
