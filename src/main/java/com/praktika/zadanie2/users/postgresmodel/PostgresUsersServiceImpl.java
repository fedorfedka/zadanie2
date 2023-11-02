package com.praktika.zadanie2.users.postgresmodel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

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
        user.setDefaultCurrency(userDto.getName());
        User createdUser = userRepository.save(user);
        return new UserDto(createdUser.getId(), createdUser.getDefaultCurrency(), createdUser.getName());
    }

    @Override
    public List<UserDto> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public UserDto getUserById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public UserDto deleteUserById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserById'");
    }

    @Override
    public UserDto updateUserById(Long id, UserDto userDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUserById'");
    }

}
