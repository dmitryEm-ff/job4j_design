package ru.job4j.ood.isp;

public class TaskThree implements MenuItem {
    private UserAction userAction;

    public TaskThree(UserAction userAction) {
        this.userAction = userAction;
    }

    public UserAction getUserAction() {
        return userAction;
    }
}
