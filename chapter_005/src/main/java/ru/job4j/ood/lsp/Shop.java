package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Shop implements Storage {
    private final List<Food> store = new ArrayList<>();
    private int discountPercent;

    @Override
    public boolean accept(Food food) {
        if (getDaysCurrent(food) > getDaysAnyPercent(food, 25) &&
                getDaysCurrent(food) < getDaysFull(food)) {
            if (getDaysCurrent(food) > getDaysAnyPercent(food, 75)) {
                discountPercent = 30;
                discountToFood(food, discountPercent);
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

    public void discountToFood(Food food, int discountPercent) {
        food.setDiscount(discountPercent);
        food.setPrice(food.getPrice() - getDiscount(food));
    }
}