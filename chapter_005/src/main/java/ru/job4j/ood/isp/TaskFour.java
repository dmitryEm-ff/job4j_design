package ru.job4j.ood.isp;

public class TaskFour implements MenuItem {
    private UserAction userAction;

    public TaskFour(UserAction userAction) {
        this.userAction = userAction;
    }

    public UserAction getUserAction() {
        return userAction;
    }
}
