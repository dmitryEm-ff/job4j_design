package ru.job4j.ood.isp;

import java.util.List;

public interface MenuItem {
    String getTitle();
    UserAction getUserAction();
    void setChildren(MenuItem children);
    List<MenuItem> getChildren();
}