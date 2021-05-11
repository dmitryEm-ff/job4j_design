package ru.job4j.ood.dip;

import java.util.List;

public class ControlQuality implements Control {

    private final List<Storage> storageMap;

    public ControlQuality(List<Storage> storageMap) {
        this.storageMap = storageMap;
    }

    @Override
    public Storage applyQualityControl(Food food) {
        for (Storage s : storageMap) {
            if (s.accept(food)) {
                s.addFood(food);
                return s;
            }
        }
        return null;
    }
}