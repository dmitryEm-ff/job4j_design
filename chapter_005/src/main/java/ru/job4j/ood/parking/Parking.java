package ru.job4j.ood.parking;

import java.util.List;

/**
 * Interface of parking
 *
 * @author Dmitry Emelyanov
 * @version 1.0
 * @since 20.04.2021
 */
public interface Parking {

    /**
     * Method should park a car
     *
     * @param car
     * @return boolean
     */
    boolean park(Car car);

    /**
     * Method should return list of all small cars
     *
     * @return list
     */
    List<Place> getAllSmallCars();

    /**
     * Method should return list of all big cars
     *
     * @return list
     */
    List<Place> getAllBigCars();

    /**
     * Method should return free spaces for big cars
     *
     * @return int
     */
    int getFreeSpaceBigCar();

    /**
     * Method should return free spaces for small cars
     *
     * @return int
     */
    int getFreeSpaceSmallCar();
}