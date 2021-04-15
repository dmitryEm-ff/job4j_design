package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash {
    private final List<Food> store = new ArrayList<>();

    public void add(Food food) {
        store.add(food);
    }
}
