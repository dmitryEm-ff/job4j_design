package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements FoodStrategy {
    private final List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }
}