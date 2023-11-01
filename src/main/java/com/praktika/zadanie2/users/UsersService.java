package com.praktika.zadanie2.users;


import java.util.List;

public interface UsersService {
    public abstract UserDto createUser(UserDto user);
    public abstract List<UserDto> getAllUsers();
    public abstract UserDto getUserById(Long id);
    public abstract UserDto deleteUserById(Long id);
    public abstract UserDto updateUserById(Long id, UserDto user);
}
