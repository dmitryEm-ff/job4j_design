package ru.job4j.ood.parking;

public class PassengerCar implements Car {

    private final int size = 1;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "PassengerCar{"
                + "size=" + size
                + '}';
    }
}