package com.praktika.zadanie2.operations;

public class Operation {
    private Long amount;
    private String currency;
    private String date;
    private String description;

    public Operation(Long amount, String currency, String date, String description) {
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.description = description;
    }

    public Long getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }
}
