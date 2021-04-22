package ru.job4j.ood.parking;

import java.util.List;

public interface Parking {

    boolean park(Car car);
    List<Place> getAllSmallCars();
    List<Place> getAllBigCars();
    int getFreeSpaceBigCar();
    int getFreeSpaceSmallCar();
}