package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size;
    private T value;

    public T pop() {
        value = linked.deleteFirstStack();
        size--;
        return value;
    }

    public void push(T value) {
        linked.addFirst(value);
        size++;
    }

    public T popLast() {
        value = linked.deleteLast();
        size--;
        return value;
    }

    public void pushLast(T value) {
        linked.add(value);
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}