package ru.job4j.ood.isp;

import java.util.ArrayList;
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
            List<MenuItem> absorbed = showMenu(menuItems);
            System.out.println("Select something: ");
            int select = Integer.valueOf(scanner.nextLine());
            MenuItem item = absorbed.get(select);
            run = item.getUserAction().execute();
        }
    }

    @Override
    public List<MenuItem> showMenu(List<MenuItem> menuItems) {
        List<MenuItem> rsl = new ArrayList<>();
        System.out.println(title);
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem tmp = menuItems.get(i);
            rsl.add(tmp);
            System.out.println(i + " --" + tmp.getTitle());
            rsl = check(rsl, tmp);
        }
        return rsl;
    }

    public List<MenuItem> check(List<MenuItem> rsl, MenuItem menuItem) {
        if (menuItem.getChildren().size() != 0) {
            for (int i = 0; i < menuItem.getChildren().size(); i++) {
                MenuItem tmp = menuItem.getChildren().get(i);
                rsl.add(tmp);
                System.out.println(i + " --" + tmp.getTitle());
                check(rsl, tmp);
                rsl = check(rsl, tmp);
            }
        }
        return rsl;
    }
}