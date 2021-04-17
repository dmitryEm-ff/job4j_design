package ru.job4j.ood.lsp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenWarehouse() {
        ControlQuality controlQuality = new ControlQuality();
        Food beer = new Drinks("beer",
                LocalDateTime.of(2021, 5, 30, 0, 0),
                LocalDateTime.of(2021, 4, 15, 0, 0),
                150, 0);
        Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(Warehouse.class.getName()));
        assertThat(storage.getAll(), is(List.of(beer)));
    }

    @Test
    public void whenTrash() {
        ControlQuality controlQuality = new ControlQuality();
        Food beer = new Drinks("beer",
                LocalDateTime.of(2021, 4, 17, 0, 0),
                LocalDateTime.of(2021, 4, 15, 0, 0),
                150, 0);
        Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(Trash.class.getName()));
        assertThat(storage.getAll(), is(List.of(beer)));
    }

    @Test
    public void whenShopAndDiscountZero() {
        ControlQuality controlQuality = new ControlQuality();
        Food beer = new Drinks("beer",
                LocalDateTime.of(2021, 5, 1, 0, 0),
                LocalDateTime.of(2021, 4, 1, 0, 0),
                150, 0);
        Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(Shop.class.getName()));
        assertThat(storage.getAll().get(0).getDiscount(), is(0));
    }

    @Test
    public void whenShopAndDiscountIs30() {
        ControlQuality controlQuality = new ControlQuality();
        Food beer = new Drinks("beer",
                LocalDateTime.of(2021, 5, 1, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0),
                150, 0);
        Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(Shop.class.getName()));
        assertThat(storage.getAll().get(0).getDiscount(), is(30));
    }
}