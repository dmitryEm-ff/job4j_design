package ru.job4j.ood.isp;

import java.util.List;
import java.util.Scanner;

public class MainMenu implements Menu {
    private String title;
    private List<MenuItem> menuItems;
    private Scanner scanner = new Scanner(System.in);

    public MainMenu(String title, List<MenuItem> menuItems) {
        this.title = title;
        this.menuItems = menuItems;
    }

    @Override
    public void init(List<MenuItem> menuItems) {
        boolean run = true;
        while (run) {
            showMenu(menuItems);
            System.out.println("Select something: ");
            int select = Integer.valueOf(scanner.nextLine());
            MenuItem item = menuItems.get(select);
            run = item.getUserAction().execute();
        }
    }

    @Override
    public void showMenu(List<MenuItem> menuItems) {
        System.out.println(title);
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem.getTitle());
        }
    }
}