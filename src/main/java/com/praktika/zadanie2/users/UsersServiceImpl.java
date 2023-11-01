package com.praktika.zadanie2.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.praktika.zadanie2.users.listmodel.ListUser;
import com.praktika.zadanie2.users.listmodel.ListUserModel;

@Service
@Profile("fakedb")
public class UsersServiceImpl implements UsersService {
    @Autowired
    ListUserModel userModel;

    @Override
    public UserDto createUser(UserDto user) {
        ListUser listUser = new ListUser(user.getDefaultCurrency(), user.getName());
        userModel.create(listUser);
        user.setId(userModel.getCurrentId());
        return user;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<>();
        List<ListUser> listUsers = userModel.findAll();
        for (ListUser listUser : listUsers) {
            users.add(new UserDto(listUser.getId(), listUser.getDefaultCurrency(), listUser.getName()));
        }
        return users;
    }

    @Override
    public UserDto getUserById(Long id) {
        ListUser user = userModel.findById(id);
        return new UserDto(id, user.getDefaultCurrency(), user.getName());
    }

    @Override
    public UserDto deleteUserById(Long id) {
        ListUser user = userModel.delete(id);
        if (user == null) {
            return null;
        }
        user.setId(userModel.getCurrentId());
        return new UserDto();

    }

    @Override
    public UserDto updateUserById(Long id, UserDto user) {
        ListUser listUser = new ListUser(user.getDefaultCurrency(), user.getName());
        ListUser updatedUser = userModel.update(id, listUser);
        if (updatedUser == null) {
            return null;
        }
        return new UserDto(id, user.getDefaultCurrency(), user.getName());
    }
}
