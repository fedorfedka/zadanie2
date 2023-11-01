package com.praktika.zadanie2.users;

public class UserDto {

    private Long id;
    private String defaultCurrency;
    private String name;

    public UserDto() {}

    public UserDto(Long id, String defaultCurrency, String name) {
        this.id = id;
        this.defaultCurrency = defaultCurrency;
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

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
