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
        int num = 0;
        System.out.println(title);
        for (int index = 0; index < menuItems.size(); index++) {
            check(rsl, menuItems.get(index), index);
        }
        return rsl;
    }

    public List<MenuItem> check(List<MenuItem> rsl, MenuItem tmp, int index) {
        rsl.add(tmp);
        tmp.setNumber((tmp.getNumber() + index));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tmp.getNumber());
        System.out.println(stringBuilder + " " + tmp.getTitle());
        if (tmp.getChildren().size() != 0) {
            for (int i = 0; i < tmp.getChildren().size(); i++) {
                check(rsl, tmp.getChildren().get(i), i);
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
        menuItems.get(1).getChildren().get(1).setChildren(new TaskOne("Task One", new DoSomethingOne()));
        menuItems.get(1).getChildren().get(1).setChildren(new TaskTwo("Task Two", new DoSomethingTwo()));
        Menu menu = new MainMenu("Main Menu", menuItems);
        menu.init();
    }
}