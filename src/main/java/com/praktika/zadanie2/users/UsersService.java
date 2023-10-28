package com.praktika.zadanie2.users;


import java.util.Map;

public interface UsersService {
    public abstract void createUser(User user);
    public abstract Map<Long, User> getAllUsers();
    public abstract User getUserById(Long id);
    public abstract void deleteUserById(Long id);
    public abstract void updateUserById(Long id, User user);
}
