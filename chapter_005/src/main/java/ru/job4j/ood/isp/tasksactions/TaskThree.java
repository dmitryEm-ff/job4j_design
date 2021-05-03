package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.MenuItem;
import ru.job4j.ood.isp.UserAction;

public class TaskThree implements MenuItem {
    private UserAction userAction;

    public TaskThree(UserAction userAction) {
        this.userAction = userAction;
    }

    public UserAction getUserAction() {
        return userAction;
    }
}
