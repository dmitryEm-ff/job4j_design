package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isPresent()) {
            Node<E> element = parentNode.get();
            if (findBy(child).isEmpty()) {
                element.children.add(new Node<>(child));
                return true;
            }
        }
        return false;
    }

//    @Override
//    public Optional<Node<E>> findBy(E value) {
//        Optional<Node<E>> rsl = Optional.empty();
//        Queue<Node<E>> data = new LinkedList<>();
//        data.offer(this.root);
//        while (!data.isEmpty()) {
//            Node<E> el = data.poll();
//            if (el.value.equals(value)) {
//                rsl = Optional.of(el);
//                break;
//            }
//            data.addAll(el.children);
//        }
//        return rsl;
//    }
//
//    public boolean isBinary() {
//        boolean rsl = true;
//        Queue<Node<E>> data = new LinkedList<>();
//        data.offer(this.root);
//        while (!data.isEmpty()) {
//            Node<E> el = data.poll();
//            if (el.children.size() > 3) {
//                rsl = false;
//                break;
//            }
//            data.addAll(el.children);
//        }
//        return rsl;
//    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> predicate =  new Predicate<Node<E>>() {
            @Override
            public boolean test(Node<E> eNode) {
                return eNode.value.equals(value);
            }
        };
        return (Optional<Node<E>>) commonCheck(predicate);
    }

    public boolean isBinary() {
        Predicate<Node<E>> predicate = new Predicate<Node<E>>() {
            @Override
            public boolean test(Node<E> eNode) {
                return eNode.children.size() > 3;
            }
        };
        return (boolean) commonCheck(predicate);
    }

    public E commonCheck(Predicate<Node<E>> predicate) {
        Optional<E> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = (Optional<E>) Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return (E) rsl;
    }
}