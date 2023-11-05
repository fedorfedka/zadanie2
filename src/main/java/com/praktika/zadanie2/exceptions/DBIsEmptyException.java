package com.praktika.zadanie2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DBIsEmptyException extends RuntimeException {
    private String errorMessege;
    public DBIsEmptyException() {
        errorMessege = "database is empty";
    }

    public String getErrorMessege() {
        return errorMessege;
    }
}
