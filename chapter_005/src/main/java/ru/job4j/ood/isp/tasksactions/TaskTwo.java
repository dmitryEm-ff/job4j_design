package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.MenuItem;
import ru.job4j.ood.isp.UserAction;

import java.util.ArrayList;
import java.util.List;

public class TaskTwo implements MenuItem {
    private String title;
    private UserAction userAction;
    private List<MenuItem> children = new ArrayList<>();
    private int number = 1;

    public TaskTwo(String title, UserAction userAction) {
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