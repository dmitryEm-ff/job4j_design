package ru.job4j.ood.isp;

import java.util.List;

public interface Menu {
    void init(List<MenuItem> menuItems);
    List<MenuItem> showMenu(List<MenuItem> menuItems);
}
