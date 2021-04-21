package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Warehouse implements Storage {
    private final List<Food> store = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return getDaysCurrent(food) < getDaysAnyPercent(food, 25);
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