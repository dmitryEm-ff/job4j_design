package ru.job4j.ood.srp;

public interface Format<T, U> {
    T formatter(U u);
}