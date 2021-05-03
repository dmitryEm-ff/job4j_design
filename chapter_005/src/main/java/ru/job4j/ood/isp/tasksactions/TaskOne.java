package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.MenuItem;
import ru.job4j.ood.isp.UserAction;

public class TaskOne implements MenuItem {
    private UserAction userAction;

    public TaskOne(UserAction userAction) {
        this.userAction = userAction;
    }

    public UserAction getUserAction() {
        return userAction;
    }
}
