package com.praktika.zadanie2.users;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UserModel userModel;

    @Override
    public void createUser(User user) {
        userModel.create(user);  
    }

    @Override
    public Map<Long, User> getAllUsers() {
        return userModel.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userModel.findById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userModel.delete(id);

    }

    @Override
    public void updateUserById(Long id, User user) {
        userModel.update(id, user);
    }
}
