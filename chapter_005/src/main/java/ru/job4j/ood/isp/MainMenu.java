package ru.job4j.ood.isp;

import java.util.List;

public class MainMenu implements Menu {
    private String title;
    private List<MenuItem> menuItems;

    public MainMenu(String title, List<MenuItem> menuItems) {
        this.title = title;
        this.menuItems = menuItems;
    }

    @Override
    public void showMenu(List<MenuItem> menuItems) {

    }
}