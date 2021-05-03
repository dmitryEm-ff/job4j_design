package ru.job4j.ood.isp;

import java.util.List;

public class MainMenu implements Menu {
    private List<MenuItem> menuItems;

    public MainMenu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


}
