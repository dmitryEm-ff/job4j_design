package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> store = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        store.add(food);
    }
}