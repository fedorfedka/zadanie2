package com.praktika.zadanie2.users;

import java.util.Map;

public interface UserModel {
    public abstract void create(User user);
    public abstract User findById(Long id);
    public abstract Map<Long, User> findAll();
    public abstract void update(Long id, User user);
    public abstract void delete(Long id);
    
}