package ru.job4j.ood.lsp;

import java.util.Map;

public class ControlQuality implements Control {

    private final Map<String, Storage> storageMap;

    public ControlQuality(Map<String, Storage> storageMap) {
        this.storageMap = storageMap;
    }

    @Override
    public Storage applyQualityControl(Food food) {
        for (Map.Entry<String, Storage> s : storageMap.entrySet()) {
            Storage storage = s.getValue();
            if (storage.accept(food)) {
                storage.addFood(food);
                return storage;
            }
        }
        return null;
    }
}