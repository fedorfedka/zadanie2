package com.praktika.zadanie2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullFieldException extends RuntimeException{
    private String errorMessege;
    public NullFieldException() {
        errorMessege = "Fields can't be null or emty";
    }

    public String getErrorMessege() {
        return errorMessege;
    }
}
