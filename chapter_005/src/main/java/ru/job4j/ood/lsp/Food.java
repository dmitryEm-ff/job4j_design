package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Food {
    private String name;
    private Calendar expiryDate;
    private Calendar createDate;
    private float price;
    private int discount;

    public Food(String name, Calendar expiryDate, Calendar createDate, float price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }
}