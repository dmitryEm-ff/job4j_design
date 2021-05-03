package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.UserAction;

public class DoSomethingFour implements UserAction {
    @Override
    public String name() {
        return "Action";
    }

    @Override
    public boolean execute() {
        return false;
    }
}
