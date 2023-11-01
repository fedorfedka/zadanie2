package com.praktika.zadanie2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityDoesntExistException extends RuntimeException {
    private String errorMessege;
    public EntityDoesntExistException() {
        errorMessege = "Entity does not exist";
    }

    public String getErrorMessege() {
        return errorMessege;
    }
}
