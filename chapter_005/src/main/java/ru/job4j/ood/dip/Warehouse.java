package ru.job4j.ood.dip;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> store = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        int full = calculatePercent(food.getCreateDate(), food.getExpiryDate());
        int days25perc = (int) ((full / 100.0) * 25);
        return calculatePercent(food.getCreateDate(), LocalDateTime.now()) < days25perc;
    }

    @Override
    public void addFood(Food food) {
        store.add(food);
    }

    @Override
    public List<Food> getAll() {
        return store;
    }
}