package ru.job4j.collection;

import java.util.*;

public class SimpleList<E> implements Iterable<E> {

    private int modCount;
    private int elemCount;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        modCount++;
        elemCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, elemCount);
        Node<E> nodeIndex = first;
        int point = 0;
        while (point != index) {
            nodeIndex = nodeIndex.next;
            point++;
        }
        return (E) nodeIndex.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int expectedModCount  = modCount;
            private int currentIndex = 0;
            private Node<E> nodeIter = first;

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
                currentIndex++;
                nodeIter = nodeIter.next;
                return (E) nodeIter.item;
            }
        };
    }
}