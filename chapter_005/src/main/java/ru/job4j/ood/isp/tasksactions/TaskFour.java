package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.Task;
import ru.job4j.ood.isp.UserAction;

public class TaskFour implements Task {
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
