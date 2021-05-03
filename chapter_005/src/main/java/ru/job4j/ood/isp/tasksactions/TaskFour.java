package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.MenuItem;
import ru.job4j.ood.isp.UserAction;

public class TaskFour implements MenuItem {
    private UserAction userAction;

    public TaskFour(UserAction userAction) {
        this.userAction = userAction;
    }

    public UserAction getUserAction() {
        return userAction;
    }
}
