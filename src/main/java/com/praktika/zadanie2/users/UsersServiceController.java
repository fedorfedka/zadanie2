package com.praktika.zadanie2.users;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersServiceController {
    @Autowired 
    UsersService usersService;

    @GetMapping
    public Map<Long, User> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        usersService.createUser(user);
        return user;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        usersService.deleteUserById(id);
    }

    @PatchMapping("/{id}")
    public void updateUserById(@PathVariable Long id, @RequestBody User user) {
        usersService.updateUserById(id, user);;
    }
}
