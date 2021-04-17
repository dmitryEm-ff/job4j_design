package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.ChronoUnit.*;

public class Trash implements Storage {
    private final List<Food> store = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        store.add(food);
    }

    @Override
    public List<Food> getAll() {
        return store;
    }
}