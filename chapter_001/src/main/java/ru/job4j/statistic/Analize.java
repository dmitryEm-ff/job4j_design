package ru.job4j.statistic;

import java.util.List;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0, 0, 0);
        for (User userPrev : previous) {
            for (User userCur : current) {
                if (userCur.id != userPrev.id) {
                    info.added++;
                    break;
                }
                if (userCur.name != userPrev.name) {
                    info.changed++;
                }
            }
        }
        info.deleted = (previous.size() + info.added) - current.size();
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public Info() {
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
