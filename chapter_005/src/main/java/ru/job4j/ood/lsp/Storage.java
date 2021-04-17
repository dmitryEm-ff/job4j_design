package ru.job4j.ood.lsp;

import java.util.List;

public interface Storage {

    void addFood(Food food);
    List<Food> getAll();
}