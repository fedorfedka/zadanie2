package com.praktika.zadanie2.users.postgresmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String defaultCurrency;

    @Column
    private String name;

    public User() {}

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
