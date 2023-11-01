package com.praktika.zadanie2.users.listmodel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListUserModelImpl implements ListUserModel{
    List<ListUser> users = new ArrayList<>();

    private Long id = (long) -1;

    private Long getNextId() {
        return ++id;
    }

    public Long getCurrentId() {
        return id;
    }

    @Override
    public ListUser create(ListUser user) {
        user.setId(getNextId());
        users.add(user);
        return user;
    }

    @Override
    public ListUser findById(Long id) {
        for (ListUser user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<ListUser> findAll() {
        return users;
    }

    @Override
    public ListUser update(Long id, ListUser user) {
        for (ListUser eachUser : users) {
            if (eachUser.getId().equals(id)) {
                eachUser.setName(user.getName());
                eachUser.setDefaultCurrency(user.getDefaultCurrency());
                return eachUser;
            }
        }
        return null;
    }

    @Override
    public ListUser delete(Long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.remove(i);
                return users.get(i);
            }
        }
        return null;
    }
}

