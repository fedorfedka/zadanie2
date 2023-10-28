package com.praktika.zadanie2.users;

public class User {
    private String defaultCurrency;
    private String name;
    
    public User(String defaultCurrency, String name) {
        this.defaultCurrency = defaultCurrency;
        this.name = name;
    }

    public String getdefaultCurrency() {
        return defaultCurrency;
    }

    public String getName() {
        return name;
    }
}
