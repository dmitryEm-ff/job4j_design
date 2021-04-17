package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.*;

public class ControlQuality implements Control {

    @Override
    public Storage sort(Food food) {
//        int point = (createdToExp / 100) * 25;
//        if (createdToCurrent < point) {
//            Storage storage = new Warehouse();
//            storage.addFood(food);
//        }
        Storage storage = findStorage(food);
        storage.addFood(food);
        return storage;
    }

    public Storage findStorage(Food food) {
        int createdToExp = (int) DAYS.between(food.getCreateDate(), food.getExpiryDate());
        int createdToCurrent = (int) DAYS.between(food.getCreateDate(), LocalDateTime.now());

        if (isTrash(food)) {
            return new Trash();
        }
        if (isWarehouse(food, createdToExp, createdToCurrent)) {
            return new Warehouse();
        }
        if (isShopWithDiscount(food, createdToExp, createdToCurrent)) {
            return new Shop();
        }
        return new Shop();
    }

    public boolean isWarehouse(Food food, int createdToExp, int createdToCurrent) {
        int point = (createdToExp / 100) * 25;
        return createdToCurrent < point;
    }

    public boolean isShopWithDiscount(Food food, int createdToExp, int createdToCurrent) {
        return false;

    }

    public boolean isTrash(Food food) {
        return DAYS.between(LocalDateTime.now(), food.getExpiryDate()) < 0;
    }
}