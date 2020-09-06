package ru.job4j.generic;

public class RoleStore implements Store<User> {

    private final Store<User> role = new MemStore<>();

    @Override
    public void add(User model) {
        role.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return role.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return role.delete(id);
    }

    @Override
    public User findById(String id) {
        return role.findById(id);
    }
}