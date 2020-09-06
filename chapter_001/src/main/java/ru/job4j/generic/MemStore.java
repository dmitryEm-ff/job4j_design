package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int targetIndex = indexOf(id);
        if (targetIndex >= 0) {
            mem.set(targetIndex, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int targetIndex = indexOf(id);
        if (targetIndex >= 0) {
            mem.remove(targetIndex);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int targetIndex = indexOf(id);
        return targetIndex >= 0 ? mem.get(targetIndex) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
