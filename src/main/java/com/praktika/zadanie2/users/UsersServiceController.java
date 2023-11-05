package com.praktika.zadanie2.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praktika.zadanie2.exceptions.EntityDoesntExistException;
import com.praktika.zadanie2.exceptions.NullFieldException;

@RestController
@RequestMapping("/users")
public class UsersServiceController {

    
    @Autowired 
    UsersService usersService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto user) {
        if (user.getDefaultCurrency() == null || user.getName() == null) {
            throw new NullFieldException();
        }

        UserDto createdUser = usersService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
        
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(usersService.getUserById(id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        try {
            UserDto user = usersService.deleteUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (EntityDoesntExistException e) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody(required = false) UserDto user) {
        if (user != null) {
            UserDto foundUser = usersService.getUserById(id);
            if (foundUser == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                usersService.updateUserById(id, user);
                foundUser = usersService.getUserById(id);
                return new ResponseEntity<>(foundUser, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(usersService.getUserById(id), HttpStatus.OK);
        
    }
}
