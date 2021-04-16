package ru.job4j.ood.lsp;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class ControllQuality {

    public String sort(Food food) {
        Calendar currentDate = Calendar.getInstance();
        int days  = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());

        return null;
    }
}