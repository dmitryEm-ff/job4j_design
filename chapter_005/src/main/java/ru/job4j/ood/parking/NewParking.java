package ru.job4j.ood.parking;

public class NewParking implements Parking {

    private final int size;

    public NewParking(int size) {
        this.size = size;
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public Car[] getAll() {
        return new Car[0];
    }
}
