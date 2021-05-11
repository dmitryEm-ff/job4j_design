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

        for (Food food : mainList) {
            System.out.println(food.getName());
        }
    }

    public static void main(String[] args) {
        ControlQuality controlQuality = new ControlQuality(List.of(new Trash(), new Shop(), new Warehouse()));
        controlQuality.storageMap.get(0).addFood(new Drinks("beer",
                LocalDateTime.of(2021, 12, 30, 0, 0),
                LocalDateTime.of(2021, 4, 20, 0, 0),
                150, 0));

        controlQuality.storageMap.get(0).addFood(new Drinks("boor",
                LocalDateTime.of(2021, 12, 30, 0, 0),
                LocalDateTime.of(2021, 4, 20, 0, 0),
                150, 0));

        controlQuality.storageMap.get(1).addFood(new Drinks("eer",
                LocalDateTime.of(2021, 12, 30, 0, 0),
                LocalDateTime.of(2021, 4, 20, 0, 0),
                150, 0));

        controlQuality.storageMap.get(1).addFood(new Drinks("oor",
                LocalDateTime.of(2021, 12, 30, 0, 0),
                LocalDateTime.of(2021, 4, 20, 0, 0),
                150, 0));

        controlQuality.storageMap.get(2).addFood(new Drinks("er",
                LocalDateTime.of(2021, 12, 30, 0, 0),
                LocalDateTime.of(2021, 4, 20, 0, 0),
                150, 0));

        controlQuality.storageMap.get(2).addFood(new Drinks("or",
                LocalDateTime.of(2021, 12, 30, 0, 0),
                LocalDateTime.of(2021, 4, 20, 0, 0),
                150, 0));
        controlQuality.resort();
    }
}