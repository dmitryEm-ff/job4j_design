package ru.job4j.ood.lsp;

import java.util.Calendar;
import java.util.Date;

public class Meat extends Food {
    public Meat(String name, Date expiryDate, Date createDate, float price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
