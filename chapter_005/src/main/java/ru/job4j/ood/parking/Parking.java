package ru.job4j.ood.parking;

import java.util.List;

public interface Parking {

    boolean park(Car car);
    List<Car> getAllSmallCars();
    List<Car> getAllBigCars();
    int getFreeSpaceBigCar();
    int getFreeSpaceSmallCar();
}