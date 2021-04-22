package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;

public class NewParking implements Parking {

    private final List<Car> smallCarsArray;
    private final List<Car> bigCarsArray;

    public NewParking(int smallCars, int bigCars) {
        this.smallCarsArray = new ArrayList<>(smallCars);
        this.bigCarsArray = new ArrayList<>(bigCars);
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public List<Car> getAllSmallCars() {
        return smallCarsArray;
    }

    @Override
    public List<Car> getAllBigCars() {
        return bigCarsArray;
    }

    @Override
    public int getFreeSpaceBigCar() {
        return 0;
    }

    @Override
    public int getFreeSpaceSmallCar() {
        return 0;
    }

    public static void main(String[] args) {
        Parking parking = new NewParking(10, 5);
        System.out.println(parking.getAllBigCars().size());
        System.out.println(parking.getAllSmallCars().size());
    }
}