package ru.job4j.ood.dip;

import java.time.LocalDateTime;

public class Drinks extends Food {
    public Drinks(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
