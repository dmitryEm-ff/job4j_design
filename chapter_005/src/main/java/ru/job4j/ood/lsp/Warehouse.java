package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Food> store = new ArrayList<>();

    public Warehouse(List<Food> store) {
        this.store = store;
    }
}
