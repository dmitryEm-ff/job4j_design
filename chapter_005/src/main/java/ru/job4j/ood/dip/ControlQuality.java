package ru.job4j.ood.dip;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void resort() {
        List<Food> mainList = storageMap.stream()
                .flatMap(storage -> storage.getAll().stream())
                .collect(Collectors.toList());

        mainList.forEach(this::applyQualityControl);
    }
}