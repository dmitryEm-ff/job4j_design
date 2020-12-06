package ru.job4j.serialization;

public class CarParam {
    private String brand;
    private String color;

    public CarParam() {
    }

    public CarParam(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "CarParam{"
                + "brand='" + brand + '\''
                + ", color='" + color + '\''
                + '}';
    }
}
