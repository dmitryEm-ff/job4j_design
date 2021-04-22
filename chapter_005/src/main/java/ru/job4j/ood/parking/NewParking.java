package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;

public class NewParking implements Parking {

    private final List<Place> smallCarsArray;
    private final List<Place> bigCarsArray;

    public NewParking(int smallCars, int bigCars) {
        this.smallCarsArray = createSmallCarsList(smallCars);
        this.bigCarsArray = createBigCarsList(bigCars);
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public List<Place> getAllSmallCars() {
        return smallCarsArray;
    }

    @Override
    public List<Place> getAllBigCars() {
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

    public List<Place> createSmallCarsList(int size) {
        List<Place> rsl = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            rsl.add(new Place(i + 1, false));
        }
        return rsl;
    }

    public List<Place> createBigCarsList(int size) {
        List<Place> rsl = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            rsl.add(new Place(i + 1, false));
        }
        return rsl;
    }

    public static void main(String[] args) {
        Parking parking = new NewParking(10, 5);
        System.out.println(parking.getAllBigCars().size());
        System.out.println(parking.getAllSmallCars().size());
    }
}