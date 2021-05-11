package ru.job4j.ood.dip;

import java.time.LocalDateTime;

public class Cheese extends Food {
    public Cheese(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
