package ru.job4j.serialization;

public class CarParam {
    private final String brand;
    private final String color;

    public CarParam(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return "CarParam{"
                + "brand='" + brand + '\''
                + ", color='" + color + '\''
                + '}';
    }
}
