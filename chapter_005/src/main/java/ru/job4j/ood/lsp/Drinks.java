package ru.job4j.ood.lsp;

import java.util.Calendar;
import java.util.Date;

public class Drinks extends Food {
    public Drinks(String name, Date expiryDate, Date createDate, float price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
