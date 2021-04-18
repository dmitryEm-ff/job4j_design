package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Warehouse implements Storage {
    private final List<Food> store = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        float full = (int) DAYS.between(food.getCreateDate(), food.getExpiryDate());
        int current = (int) DAYS.between(food.getCreateDate(), LocalDateTime.now());
        float point = (full / 100) * 25;
        return current < point;
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