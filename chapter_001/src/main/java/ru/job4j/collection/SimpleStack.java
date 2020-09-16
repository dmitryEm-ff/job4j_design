package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
//        return linked.deleteLast();
        return linked.deleteFirstStack();
    }

    public void push(T value) {
//        linked.add(value);
        linked.addFirst(value);
    }
}