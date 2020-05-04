package com.firatcapin.stok.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends Exception  {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
