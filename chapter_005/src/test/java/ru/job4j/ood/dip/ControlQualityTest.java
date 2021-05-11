package ru.job4j.ood.dip;

import org.junit.Test;
import ru.job4j.ood.lsp.ControlQuality;
import ru.job4j.ood.lsp.Drinks;
import ru.job4j.ood.lsp.Food;
import ru.job4j.ood.lsp.Shop;
import ru.job4j.ood.lsp.Storage;
import ru.job4j.ood.lsp.Trash;
import ru.job4j.ood.lsp.Warehouse;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenWarehouse() {
        List<ru.job4j.ood.lsp.Storage> list = List.of(new ru.job4j.ood.lsp.Trash(), new ru.job4j.ood.lsp.Shop(), new ru.job4j.ood.lsp.Warehouse());
        ru.job4j.ood.lsp.ControlQuality controlQuality = new ru.job4j.ood.lsp.ControlQuality(list);
        ru.job4j.ood.lsp.Food beer = new ru.job4j.ood.lsp.Drinks("beer",
                LocalDateTime.of(2021, 12, 30, 0, 0),
                LocalDateTime.of(2021, 4, 20, 0, 0),
                150, 0);
        ru.job4j.ood.lsp.Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(ru.job4j.ood.lsp.Warehouse.class.getName()));
        assertThat(storage.getAll(), is(List.of(beer)));
    }

    @Test
    public void whenTrash() {
        List<ru.job4j.ood.lsp.Storage> list = List.of(new ru.job4j.ood.lsp.Trash(), new ru.job4j.ood.lsp.Shop(), new ru.job4j.ood.lsp.Warehouse());
        ru.job4j.ood.lsp.ControlQuality controlQuality = new ru.job4j.ood.lsp.ControlQuality(list);
        ru.job4j.ood.lsp.Food beer = new ru.job4j.ood.lsp.Drinks("beer",
                LocalDateTime.of(2021, 4, 17, 0, 0),
                LocalDateTime.of(2021, 4, 15, 0, 0),
                150, 0);
        ru.job4j.ood.lsp.Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(ru.job4j.ood.lsp.Trash.class.getName()));
        assertThat(storage.getAll(), is(List.of(beer)));
    }

    @Test
    public void whenShopAndDiscountZero() {
        List<ru.job4j.ood.lsp.Storage> list = List.of(new ru.job4j.ood.lsp.Trash(), new ru.job4j.ood.lsp.Shop(), new ru.job4j.ood.lsp.Warehouse());
        ru.job4j.ood.lsp.ControlQuality controlQuality = new ru.job4j.ood.lsp.ControlQuality(list);
        ru.job4j.ood.lsp.Food beer = new ru.job4j.ood.lsp.Drinks("beer",
                LocalDateTime.of(2021, 8, 1, 0, 0),
                LocalDateTime.of(2021, 4, 1, 0, 0),
                150, 0);
        ru.job4j.ood.lsp.Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(ru.job4j.ood.lsp.Shop.class.getName()));
        assertThat(storage.getAll().get(0).getDiscount(), is(0));
    }

    @Test
    public void whenShopAndDiscountIs30() {
        List<ru.job4j.ood.lsp.Storage> list = List.of(new Trash(), new ru.job4j.ood.lsp.Shop(), new Warehouse());
        ru.job4j.ood.lsp.ControlQuality controlQuality = new ControlQuality(list);
        Food beer = new Drinks("beer",
                LocalDateTime.of(2021, 8, 1, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0),
                150, 0);
        Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(Shop.class.getName()));
        assertThat(storage.getAll().get(0).getDiscount(), is(30));
        assertThat(storage.getAll().get(0).getPrice(), is(105.0F));
    }
}