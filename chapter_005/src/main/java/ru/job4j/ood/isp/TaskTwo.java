package ru.job4j.ood.isp;

public class TaskTwo implements MenuItem {
    private UserAction userAction;

    public TaskTwo(UserAction userAction) {
        this.userAction = userAction;
    }

    public UserAction getUserAction() {
        return userAction;
    }
}
