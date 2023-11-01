package com.praktika.zadanie2.users.postgresmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String defaultCurrency;

    @Column
    private String name;

    public UserEntity(String defaultCurrency, String name) {
        this.defaultCurrency = defaultCurrency;
        this.name = name;
    }
}
