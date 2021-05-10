package ru.job4j.ood.isp;

import java.util.List;

/**
 * Menu interface
 *
 * @author Emelyanov Dmitry
 * @version 1.0
 * @since 07.05.21
 */
public interface Menu {

    /**
     * Menu display loop
     */
    void init();

    /**
     *Displays menu
     *
     * @param menuItems
     * @return list
     */
    List<MenuItem> showMenu(List<MenuItem> menuItems);

    boolean addChildren(String parentName, MenuItem child, List<MenuItem> list);
}
