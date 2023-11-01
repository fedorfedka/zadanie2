package com.praktika.zadanie2.users.listmodel;

public class ListUser {
    private Long id;
    private String defaultCurrency;
    private String name;
    
    public ListUser(String defaultCurrency, String name) {
        this.defaultCurrency = defaultCurrency;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public String getName() {
        return name;
    }
}
