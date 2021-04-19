package ru.job4j.ood.parking;

public class CargoCar implements Car {

    private final int size = 3;

    @Override
    public int getSize() {
        return size;
    }
}