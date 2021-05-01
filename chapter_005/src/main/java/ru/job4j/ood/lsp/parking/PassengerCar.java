package ru.job4j.ood.lsp.parking;

/**
 * Class of passenger cars
 *
 * @author Dmitry Emelyanov
 * @version 1.0
 * @since 20.04.2021
 */
public class PassengerCar implements Car {

    /**
     * Car size
     */
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