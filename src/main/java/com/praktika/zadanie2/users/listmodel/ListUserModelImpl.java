package com.praktika.zadanie2.users.listmodel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.praktika.zadanie2.exceptions.EntityDoesntExistException;
import com.praktika.zadanie2.exceptions.NullFieldException;

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
        if (user.getName() != null && user.getDefaultCurrency() != null) {
            user.setId(getNextId());
            users.add(user);
            return user;
        }
        
        throw new NullFieldException();
    }

    @Override
    public ListUser findById(Long id) {
        for (ListUser user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        throw new EntityDoesntExistException();
    }

    @Override
    public List<ListUser> findAll() {
        return users;
    }

    @Override
    public ListUser update(Long id, ListUser user) {
        for (ListUser eachUser : users) {
            if (eachUser.getId().equals(id)) {
                if (user.getName() != null) {
                    eachUser.setName(user.getName());
                }
                if (user.getDefaultCurrency() != null) {
                    eachUser.setDefaultCurrency(user.getDefaultCurrency());
                }
                
                return eachUser;
            }
        }
        return null;
    }

    @Override
    public ListUser delete(Long id) {
        ListUser user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                user = users.get(i);
                users.remove(i);
                return user;
            }
        }
        return user;
    }
}

