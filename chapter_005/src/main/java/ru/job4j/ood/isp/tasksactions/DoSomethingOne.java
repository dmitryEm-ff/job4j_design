package ru.job4j.ood.isp.tasksactions;

import ru.job4j.ood.isp.UserAction;

/**
 *
 * @author Emelyanov Dmitry
 * @version 1.0
 * @since 07.05.21
 */
public class DoSomethingOne implements UserAction {

    /**
     * This method returns operation name
     *
     * @return sting name
     */
    @Override
    public String name() {
        return "Action in 1 class.";
    }

    /**
     * Method should execute an action
     *
     * @return boolean result
     */
    @Override
    public boolean execute() {
        System.out.println("My name is : " + name());
        return false;
    }
}
