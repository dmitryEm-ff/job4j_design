package ru.job4j.ood.isp;

import ru.job4j.ood.isp.tasksactions.*;

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
    public void init() {
        boolean run = true;
        while (run) {
            List<MenuItem> absorbed = showMenu(menuItems);
            System.out.printf("Select something: ");
            int select = Integer.valueOf(scanner.nextLine());
            MenuItem item = absorbed.get(select - 1);
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
            System.out.println(i + 1 + " --" + tmp.getTitle());
            rsl = check(rsl, tmp);
        }
        return rsl;
    }

    public List<MenuItem> check(List<MenuItem> rsl, MenuItem menuItem) {
        if (menuItem.getChildren().size() != 0) {
            for (int i = 0; i < menuItem.getChildren().size(); i++) {
                MenuItem tmp = menuItem.getChildren().get(i);
                rsl.add(tmp);
                System.out.println(i + 1 + " --" + tmp.getTitle());
                check(rsl, tmp);
                rsl = check(rsl, tmp);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<MenuItem> menuItems = List.of(
                new TaskOne("Task One", new DoSomethingOne()),
                new TaskTwo("Task Two", new DoSomethingTwo()),
                new TaskThree("Task Three", new DoSomethingThree()),
                new TaskFour("Task Four", new DoSomethingFour())
                );
        menuItems.get(1).setChildren(new TaskOne("Task One", new DoSomethingOne()));
        menuItems.get(1).setChildren(new TaskTwo("Task Two", new DoSomethingTwo()));
        Menu menu = new MainMenu("Main Menu", menuItems);
        menu.init();
    }
}