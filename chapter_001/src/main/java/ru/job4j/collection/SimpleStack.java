package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirstStack();
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public T popLast() {
        return linked.deleteLast();
    }

    public void pushLast(T value) {
        linked.add(value);
    }
}