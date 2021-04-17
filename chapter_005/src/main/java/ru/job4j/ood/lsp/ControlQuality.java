package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.*;

public class ControlQuality implements Control {

    @Override
    public Storage applyQualityControl(Food food) {
        Storage storage = findStorage(food);
        storage.addFood(food);
        return storage;
    }

    public Storage findStorage(Food food) {
        if (isTrash(food)) {
            return new Trash();
        }
        if (isWarehouse(food)) {
            return new Warehouse();
        }
        return new Shop();
    }

    public boolean isTrash(Food food) {
        return DAYS.between(LocalDateTime.now(), food.getExpiryDate()) < 0;
    }

    public boolean isWarehouse(Food food) {
        float full = (int) DAYS.between(food.getCreateDate(), food.getExpiryDate());
        int current = (int) DAYS.between(food.getCreateDate(), LocalDateTime.now());
        float point = (full / 100) * 25;
        return current < point;
    }

    public static void main(String[] args) {
        ControlQuality controlQuality = new ControlQuality();
        Food beer = new Drinks("beer",
                LocalDateTime.of(2021, 5, 30, 0, 0),
                LocalDateTime.of(2021, 4, 15, 0, 0),
                150, 0);
        Storage storage = controlQuality.applyQualityControl(beer);
        for (Food f : storage.getAll()) {
            System.out.println(storage.getClass() + " : " + f.getName());
        }
    }
}