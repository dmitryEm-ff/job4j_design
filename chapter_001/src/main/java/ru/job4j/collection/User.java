package ru.job4j.collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Dima", 10, Calendar.getInstance());
        User user2 = new User("Dima", 10, Calendar.getInstance());
        Map<User, Object> users = new HashMap<>();
        users.put(user1, 1);
        users.put(user2, 1);
        users.forEach((k, v) -> System.out.printf("Key: %s Value: %s \n", k, v));
    }
}
