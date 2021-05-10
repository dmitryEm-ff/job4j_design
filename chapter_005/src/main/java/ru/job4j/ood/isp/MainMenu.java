package ru.job4j.ood.isp;

import ru.job4j.ood.isp.tasksactions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Menu realisation
 *
 * @author Emelyanov Dmitry
 * @version 1.0
 * @since 07.05.21
 */

public class MainMenu implements Menu {

    /**
     * Main menu title
     */
    private String title;

    /**
     * Menu items list
     */
    private List<MenuItem> menuItems;

    /**
     * User input
     */
    private Scanner scanner = new Scanner(System.in);

    public MainMenu(String title, List<MenuItem> menuItems) {
        this.title = title;
        this.menuItems = menuItems;
    }

    /**
     * Menu display loop
     */
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

    /**
     *Displays the title of main menu and checks all items
     *
     * @param menuItems
     * @return list with all menu items and their children
     */
    @Override
    public List<MenuItem> showMenu(List<MenuItem> menuItems) {
        List<MenuItem> rsl = new ArrayList<>();
        int num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(title);
        for (int index = 0; index < menuItems.size(); index++) {
            check(rsl, menuItems.get(index), index, stringBuilder);
            stringBuilder.setLength(0);
        }
        return rsl;
    }

    /**
     * Checking each menu item and printing its number
     *
     * @param rsl list with current elements
     * @param tmp current menu item
     * @param index index of the item in the list
     * @param stringBuilder
     * @return list with result
     */
    public List<MenuItem> check(List<MenuItem> rsl, MenuItem tmp, int index, StringBuilder stringBuilder) {
        rsl.add(tmp);
        tmp.setNumber((tmp.getNumber() + index));
        stringBuilder.append(tmp.getNumber());
        System.out.println(rsl.size() + ".  " + stringBuilder + " " + tmp.getTitle());
        if (tmp.getChildren().size() != 0) {
            stringBuilder.insert(0, "--");
            for (int i = 0; i < tmp.getChildren().size(); i++) {
                stringBuilder.append(".");
                check(rsl, tmp.getChildren().get(i), i, stringBuilder);
                stringBuilder.setLength(stringBuilder.length() - (1 + String.valueOf(i).length()));
            }
        }
        return rsl;
    }

    @Override
    public boolean addChildren(String parentName, MenuItem child, List<MenuItem> list) {
        for (MenuItem mi : list) {
            if (mi.getTitle().equals(parentName)) {
                mi.getChildren().add(child);
                return true;
            } else {
                addChildren(parentName, child, mi.getChildren());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<MenuItem> menuItems = List.of(
                new TaskOne("Task One", new DoSomethingOne()),
                new TaskTwo("Task Two", new DoSomethingTwo()),
                new TaskThree("Task Three", new DoSomethingThree()),
                new TaskFour("Task Four", new DoSomethingFour())
                );
//        menuItems.get(1).setChildren(new TaskOne("Task One", new DoSomethingOne()));
//        menuItems.get(1).setChildren(new TaskTwo("Task Two", new DoSomethingTwo()));
//        menuItems.get(1).getChildren().get(1).setChildren(new TaskOne("Task One", new DoSomethingOne()));
//        menuItems.get(1).getChildren().get(1).setChildren(new TaskTwo("Task Two", new DoSomethingTwo()));

        Menu menu = new MainMenu("Main Menu", menuItems);

        menu.addChildren("Task Two", new TaskOne("Task Two One", new DoSomethingOne()), menuItems);
        menu.addChildren("Task Two", new TaskTwo("Task Two Two", new DoSomethingTwo()), menuItems);
        menu.addChildren("Task Two Two", new TaskTwo("Task Two Two One", new DoSomethingTwo()), menuItems);
        menu.addChildren("Task Two Two", new TaskTwo("Task Two Two Two", new DoSomethingTwo()), menuItems);

        menu.init();
    }
}