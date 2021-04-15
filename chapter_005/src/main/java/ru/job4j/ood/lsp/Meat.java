package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Meat extends Food {
    public Meat(String name, Calendar expiryDate, Calendar createDate, float price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
