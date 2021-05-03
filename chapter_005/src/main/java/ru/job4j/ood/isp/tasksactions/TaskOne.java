package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.MenuItem;
import ru.job4j.ood.isp.UserAction;

public class TaskOne implements MenuItem {
    private String title;
    private UserAction userAction;

    public TaskOne(String title, UserAction userAction) {
        this.title = title;
        this.userAction = userAction;
    }

    public String getTitle() {
        return title;
    }

    public UserAction getUserAction() {
        return userAction;
    }
}
