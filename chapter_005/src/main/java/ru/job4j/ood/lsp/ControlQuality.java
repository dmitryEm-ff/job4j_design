package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.*;

public class ControlQuality implements Control {

    @Override
    public Storage sort(Food food) {
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
        int full = (int) DAYS.between(food.getCreateDate(), food.getExpiryDate());
        int current = (int) DAYS.between(food.getCreateDate(), LocalDateTime.now());
        int point = (full / 100) * 25;
        return current < point;
    }
}