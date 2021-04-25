package ru.job4j.ood.parking;

/**
 * Class of place
 *
 * @author Dmitry Emelyanov
 * @version 1.0
 * @since 20.04.2021
 */
public class Place {

    /**
     * Place number
     */
    private int placeNumber;

    /**
     * Place status, taken or not
     */
    private boolean status;

    /**
     * Car
     */
    private Car car;

    public Place(int placeNumber, boolean status) {
        this.placeNumber = placeNumber;
        this.status = status;
    }

    public Place(int placeNumber, boolean status, Car car) {
        this.placeNumber = placeNumber;
        this.status = status;
        this.car = car;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Place{"
                + "placeNumber=" + placeNumber
                + ", status=" + status
                + ", car=" + car
                + '}';
    }
}
