package ru.job4j.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private T value;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> element = head;
        while (element.next != null) {
            if (element.next.next == null) {
                value = element.next.value;
                element.next = null;
                return value;
            }
            element = element.next;
        }
        value = element.value;
        return value;
    }

    public void addStack(T value) {
        Node<T> node = new Node<T>(value, head);
        if (head == null) {
            head = node;
            return;
        }
        if (head.next == null) {
            head.next = head;
            head = node;
        }
    }

    public T deleteFirstStack() {
        if (head == null) {
            throw new NoSuchElementException();
        } else if (head.next == null) {
            value = head.value;
            head = null;
            return value;
        }
        value = head.value;
        head = head.next;
        return value;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}