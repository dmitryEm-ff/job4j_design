package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.MenuItem;
import ru.job4j.ood.isp.UserAction;

import java.util.ArrayList;
import java.util.List;

/**
 *MenuItem class realisation
 *
 * @author Emelyanov Dmitry
 * @version 1.0
 * @since 07.05.21
 */
public class TaskThree implements MenuItem {

    /**
     *Items name
     */
    private String title;

    /**
     *Action in this method
     */
    private UserAction userAction;

    /**
     *List with subithems
     */
    private List<MenuItem> children = new ArrayList<>();

    /**
     *Serial number of this item
     */
    private int number = 1;

    public TaskThree(String title, UserAction userAction) {
        this.title = title;
        this.userAction = userAction;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public UserAction getUserAction() {
        return userAction;
    }

    @Override
    public void setChildren(MenuItem children) {
        this.children.add(children);
    }

    @Override
    public List<MenuItem> getChildren() {
        return children;
    }
}