package ru.job4j.ood.isp;

public class TaskOne implements MenuItem {
    private UserAction userAction;

    public TaskOne(UserAction userAction) {
        this.userAction = userAction;
    }

    public UserAction getUserAction() {
        return userAction;
    }
}
