package ru.job4j.ood.isp;

import java.util.List;

/**
 *Items interface
 *
 * @author Emelyanov Dmitry
 * @version 1.0
 * @since 07.05.21
 */
public interface MenuItem {
    String getTitle();
    UserAction getUserAction();
//    void setChildren(MenuItem children);
    List<MenuItem> getChildren();
    int getNumber();
    void setNumber(int number);
}