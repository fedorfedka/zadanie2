package com.praktika.zadanie2.users.postgresmodel;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
}