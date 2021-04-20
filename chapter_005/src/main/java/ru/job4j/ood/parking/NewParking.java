package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;

public class NewParking implements Parking {

    private final int smallCars;
    private final int bigCars;

    public NewParking(int smallCars, int bigCars) {
        this.smallCars = smallCars;
        this.bigCars = bigCars;
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public List<Car> getAll() {
        return new ArrayList();
    }

    @Override
    public int getFreeSpaceBigCar() {
        return 0;
    }

    @Override
    public int getFreeSpaceSmallCar() {
        return 0;
    }
}