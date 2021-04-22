package ru.job4j.ood.parking;

public class Place {

    private int placeNumber;
    private boolean status;
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
}
