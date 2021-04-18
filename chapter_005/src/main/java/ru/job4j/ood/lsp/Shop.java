package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Shop implements Storage {
    private final List<Food> store = new ArrayList<>();
    private int percent;

    @Override
    public boolean accept(Food food) {
        float full = (int) DAYS.between(food.getCreateDate(), food.getExpiryDate());
        int current = (int) DAYS.between(food.getCreateDate(), LocalDateTime.now());
        float point = (full / 100) * 75;
        float point2 = (full / 100) * 25;
        if (current > point2 && current < full) {
            if (current > point) {
                percent = 30;
                discountToFood(food, percent);
            }
            return true;
        }
        return false;
    }

    @Override
    public void addFood(Food food) {
        store.add(food);
    }

    @Override
    public List<Food> getAll() {
        return store;
    }

    private void discountToFood(Food food, int percent) {
        food.setDiscount(percent);
        food.setPrice(food.getPrice() - ((food.getPrice() / 100) * percent));
    }
}