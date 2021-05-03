package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.MenuItem;
import ru.job4j.ood.isp.UserAction;

public class TaskFour implements MenuItem {
    private String title;
    private UserAction userAction;

    public TaskFour(String title, UserAction userAction) {
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
