package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Meat extends Food {
    public Meat(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
