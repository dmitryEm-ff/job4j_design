package ru.job4j.ood.parking;

public class PassengerCar implements Car {

    private final int size = 1;
    private boolean status = false;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }
}