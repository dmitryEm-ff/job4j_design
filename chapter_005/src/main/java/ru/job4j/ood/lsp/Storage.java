package ru.job4j.ood.lsp;

import java.util.List;

public interface Storage {

    boolean accept(Food food);
    void addFood(Food food);
    List<Food> getAll();

    default void discountToFood(Food food, int percent) {
        food.setDiscount(percent);
        food.setPrice(food.getPrice() - ((food.getPrice() / 100) * percent));
    }
}