package com.praktika.zadanie2.users.listmodel;

import java.util.List;

public interface ListUserModel {
    public abstract ListUser create(ListUser user);
    public abstract ListUser findById(Long id);
    public abstract List<ListUser> findAll();
    public abstract ListUser update(Long id, ListUser user);
    public abstract ListUser delete(Long id);
    public abstract Long getCurrentId();
    
}