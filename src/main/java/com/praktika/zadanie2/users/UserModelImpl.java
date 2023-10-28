package com.praktika.zadanie2.users;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UserModelImpl implements UserModel{
    Map<Long, User> users = new HashMap<>();

    private Long id = (long) -1;

    private Long getNextId() {
        return ++id;
    }

    @Override
    public void create(User user) {
        users.put(getNextId(), user);
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public Map<Long, User> findAll() {
        return users;
    }

    @Override
    public void update(Long id, User user) {
        users.replace(id, user);
    }

    @Override
    public void delete(Long id) {
        users.remove(id);
    }
}
