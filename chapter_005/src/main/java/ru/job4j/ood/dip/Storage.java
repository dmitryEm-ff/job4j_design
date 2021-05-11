package ru.job4j.ood.dip;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public interface Storage {

    boolean accept(Food food);
    void addFood(Food food);
    List<Food> getAll();


    default int calculatePercent(LocalDateTime start, LocalDateTime end) {
        return (int) DAYS.between(start, end);
    }

//    default int getDaysFull(Food food) {
//        return (int) DAYS.between(food.getCreateDate(), food.getExpiryDate());
//    }
//
//    default int getDaysCurrent(Food food) {
//        return (int) DAYS.between(food.getCreateDate(), LocalDateTime.now());
//    }
//
//    default int getDaysNowToExp(Food food) {
//        return (int) DAYS.between(LocalDateTime.now(), food.getExpiryDate());
//    }
//
//    default int getDaysAnyPercent(Food food, int percent) {
//        return (int) ((getDaysFull(food) / 100.0) * percent);
//    }
}