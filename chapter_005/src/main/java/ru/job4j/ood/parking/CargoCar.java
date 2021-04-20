package ru.job4j.ood.parking;

public class CargoCar implements Car {

    private final int size;

    public CargoCar(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}