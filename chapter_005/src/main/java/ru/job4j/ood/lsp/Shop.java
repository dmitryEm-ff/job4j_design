package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Food> store = new ArrayList<>();

    public Shop(List<Food> store) {
        this.store = store;
    }
}
