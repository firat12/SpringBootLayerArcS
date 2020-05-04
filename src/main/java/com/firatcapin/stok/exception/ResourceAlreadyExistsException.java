package com.firatcapin.stok.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceAlreadyExistsException extends Exception {

    public ResourceAlreadyExistsException() {
    }

    public ResourceAlreadyExistsException(String msg) {
        super(msg);
    }

    public ResourceAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
