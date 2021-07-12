package ru.job4j.ood.dip;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

//    @Test
//    public void whenWarehouse() {
//        List<Storage> list = List.of(new Trash(), new Shop(), new Warehouse());
//        ControlQuality controlQuality = new ControlQuality(list);
//        Food beer = new Drinks("beer",
//                LocalDateTime.of(2021, 12, 30, 0, 0),
//                LocalDateTime.of(2021, 4, 20, 0, 0),
//                150, 0);
//        Storage storage = controlQuality.applyQualityControl(beer);
//        assertThat(storage.getClass().getName(), is(Warehouse.class.getName()));
//        assertThat(storage.getAll(), is(List.of(beer)));
//    }

    @Test
    public void whenTrash() {
        List<Storage> list = List.of(new Trash(), new Shop(), new Warehouse());
        ControlQuality controlQuality = new ControlQuality(list);
        Food beer = new Drinks("beer",
                LocalDateTime.of(2021, 4, 17, 0, 0),
                LocalDateTime.of(2021, 4, 15, 0, 0),
                150, 0);
        Storage storage = controlQuality.applyQualityControl(beer);
        assertThat(storage.getClass().getName(), is(Trash.class.getName()));
        assertThat(storage.getAll(), is(List.of(beer)));
    }

//    @Test
//    public void whenShopAndDiscountZero() {
//        List<Storage> list = List.of(new Trash(), new Shop(), new Warehouse());
//        ControlQuality controlQuality = new ControlQuality(list);
//        Food beer = new Drinks("beer",
//                LocalDateTime.of(2021, 8, 1, 0, 0),
//                LocalDateTime.of(2021, 4, 1, 0, 0),
//                150, 0);
//        Storage storage = controlQuality.applyQualityControl(beer);
//        assertThat(storage.getClass().getName(), is(Shop.class.getName()));
//        assertThat(storage.getAll().get(0).getDiscount(), is(0));
//    }

    @Test
    public void whenShopAndDiscountIs30() {
        List<Storage> list = List.of(new Trash(), new Shop(), new Warehouse());
        ControlQuality controlQuality = new ControlQuality(list);
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