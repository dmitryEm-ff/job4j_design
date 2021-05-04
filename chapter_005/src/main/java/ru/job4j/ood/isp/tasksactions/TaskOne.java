package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.MenuItem;
import ru.job4j.ood.isp.UserAction;

import java.util.ArrayList;
import java.util.List;

public class TaskOne implements MenuItem {
    private String title;
    private UserAction userAction;
    private List<MenuItem> children = new ArrayList<>();
    private int number = 0;


    public TaskOne(String title, UserAction userAction) {
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
        children.setNumber(children.getNumber() + 1);
        this.children.add(children);
    }

    @Override
    public List<MenuItem> getChildren() {
        return children;
    }
}
