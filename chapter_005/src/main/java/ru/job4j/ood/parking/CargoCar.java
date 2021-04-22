package ru.job4j.ood.parking;

public class CargoCar implements Car {

    private final int size;
    private boolean status = false;

    public CargoCar(int size) {
        this.size = size;
    }

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