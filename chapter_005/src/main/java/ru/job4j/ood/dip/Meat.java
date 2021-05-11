package ru.job4j.ood.dip;

import java.time.LocalDateTime;

public class Meat extends Food {
    public Meat(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
