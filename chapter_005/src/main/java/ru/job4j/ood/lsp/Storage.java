package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public interface Storage {

    boolean accept(Food food);
    void addFood(Food food);
    List<Food> getAll();

    default int getDiscount(Food food) {
        return (int) ((food.getPrice() / 100) * food.getDiscount());
    }

    default int getDaysFull(Food food) {
        return (int) DAYS.between(food.getCreateDate(), food.getExpiryDate());
    }

    default int getDaysCurrent(Food food) {
        return (int) DAYS.between(food.getCreateDate(), LocalDateTime.now());
    }

    default int getDaysNowToExp(Food food) {
        return (int) DAYS.between(LocalDateTime.now(), food.getExpiryDate());
    }

    default int getDaysAnyPercent(Food food, int percent) {
        return (int) ((getDaysFull(food) / 100.0) * percent);
    }
}