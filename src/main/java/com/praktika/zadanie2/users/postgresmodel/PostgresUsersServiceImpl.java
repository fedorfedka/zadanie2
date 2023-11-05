package com.praktika.zadanie2.users.postgresmodel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.praktika.zadanie2.exceptions.DBIsEmptyException;
import com.praktika.zadanie2.users.UserDto;
import com.praktika.zadanie2.users.UsersService;

@Service
@Profile("postgres")
public class PostgresUsersServiceImpl implements UsersService {

    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setDefaultCurrency(userDto.getDefaultCurrency());
        User createdUser = userRepository.save(user);
        return new UserDto(createdUser.getId(), createdUser.getDefaultCurrency(), createdUser.getName());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> usersFromDB = (List<User>) userRepository.findAll();
        List<UserDto> allUsers = new ArrayList<>();
        for (User user : usersFromDB) {
            allUsers.add(new UserDto(user.getId(), user.getDefaultCurrency(), user.getName()));
        }
        return allUsers;
    }

    @Override
    public UserDto getUserById(Long id) {
        java.util.Optional<User> usersForUpdate = userRepository.findById(id);
        if (usersForUpdate.isPresent()) {
            User userForUpdate = usersForUpdate.get();
            return new UserDto(userForUpdate.getId(), userForUpdate.getDefaultCurrency(), userForUpdate.getName());
        } else {
            throw new DBIsEmptyException();
        }
    }

    @Override
    public UserDto deleteUserById(Long id) {
        java.util.Optional<User> usersToDelete = userRepository.findById(id);
        if (usersToDelete.isPresent()) {
            User deletedUser = usersToDelete.get();
            userRepository.deleteById(id);
            return new UserDto(deletedUser.getId(), deletedUser.getDefaultCurrency(), deletedUser.getName());
        } else {
            return null;
        }
        
        
    }

    @Override
    public UserDto updateUserById(Long id, UserDto userDto) {

        java.util.Optional<User> usersForUpdate = userRepository.findById(id);
        if (usersForUpdate.isPresent()) {
            User userForUpdate = usersForUpdate.get();
            if (userDto.getDefaultCurrency() != null) {
                userForUpdate.setDefaultCurrency(userDto.getDefaultCurrency());
            }

            if (userDto.getName() != null) {
                userForUpdate.setName(userDto.getName());
            }

            userRepository.save(userForUpdate);
            userForUpdate = userRepository.findById(id).get();
            return new UserDto(userForUpdate.getId(), userForUpdate.getDefaultCurrency(), userForUpdate.getName());
        } else {
            throw new DBIsEmptyException();
        }
        

        
        // if (usersForUpdate == null) 
        // if (userDto.getDefaultCurrency() != null) {
        //     userForUpdate.setDefaultCurrency(userDto.getDefaultCurrency());
        // }

        // if (userDto.getName() != null) {
        //     userForUpdate.setName(userDto.getName());
        // }
        // userRepository.save(userForUpdate);
        // userForUpdate = userRepository.findById(id).get();
        // return new UserDto(userForUpdate.getId(), userForUpdate.getDefaultCurrency(), userForUpdate.getName());
    }

}
