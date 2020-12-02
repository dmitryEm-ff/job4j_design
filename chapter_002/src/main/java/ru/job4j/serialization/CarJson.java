package ru.job4j.serialization;

import java.util.Arrays;

public class CarJson {
    private final boolean gas;
    private final int yearOfManufacture;
    private final CarParam carParam;
    private final String[] carOwner;

    public CarJson(boolean gas, int yearOfManufacture, CarParam carParam, String[] carOwner) {
        this.gas = gas;
        this.yearOfManufacture = yearOfManufacture;
        this.carParam = carParam;
        this.carOwner = carOwner;
    }

    @Override
    public String toString() {
        return "CarJson{" +
                "gas=" + gas +
                ", yearOfManufacture=" + yearOfManufacture +
                ", carParam=" + carParam +
                ", carOwner=" + Arrays.toString(carOwner) +
                '}';
    }

    public static void main(String[] args) {

    }
}
