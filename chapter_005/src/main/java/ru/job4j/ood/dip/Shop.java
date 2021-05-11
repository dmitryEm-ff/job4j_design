package ru.job4j.ood.dip;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private final List<Food> store = new ArrayList<>();
    private int discountPercent;

    @Override
    public boolean accept(Food food) {
        int full = calculatePercent(food.getCreateDate(), food.getExpiryDate());
        int current = calculatePercent(food.getCreateDate(), LocalDateTime.now());
        int days75perc = (int) ((full / 100.0) * 75);
        int days25perc = (int) ((full / 100.0) * 25);
        if (current > days25perc && current < full) {
            if (current > days75perc) {
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
        food.setPrice(food.getPrice() - ((food.getPrice() / 100) * food.getDiscount()));
    }
}