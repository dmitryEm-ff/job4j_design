package ru.job4j.ood.parking;

import java.util.List;

public interface Parking {

    boolean park(Car car);
    List<Car> getAll();
    List<Car> getFreeSpaceBigCar();
    List<Car> getFreeSpaceSmallCar();
}