package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Shop implements Storage {
    private final List<Food> store = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        int full = (int) DAYS.between(food.getCreateDate(), food.getExpiryDate());
        int current = (int) DAYS.between(food.getCreateDate(), LocalDateTime.now());
        int point = (full / 100) * 75;
        if (current > point) {
            food.setDiscount(30);
        }
        store.add(food);
    }
}