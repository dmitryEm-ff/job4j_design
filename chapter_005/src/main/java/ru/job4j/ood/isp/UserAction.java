package ru.job4j.ood.isp;

/**
 *
 * @author Emelyanov Dmitry
 * @version 1.0
 * @since 07.05.21
 */
public interface UserAction {

    /**
     * This method returns operation name
     *
     * @return string name
     */
    String name();

    /**
     * Method should execute an action
     *
     * @return boolean result
     */
    boolean execute();
}
