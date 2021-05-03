package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.UserAction;

public class DoSomethingThree implements UserAction {
    @Override
    public String name() {
        return "Action in 3 class.";
    }

    @Override
    public boolean execute() {
        System.out.println("My name is : " + name());
        return false;
    }
}
