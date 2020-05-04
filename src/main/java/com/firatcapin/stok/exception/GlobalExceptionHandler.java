package com.firatcapin.stok.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Controlled Based Exception Handling yaklasiminda sadece ilgili Controller da ortaya cikan exceptionlar yakalanacaktir.
 * Bununla birlikte her Controller icin bu tanimi tek tek yapmak yerine daha genel bir cozum yapabiliriz.
 * burada @Controller yerine @ControllerAdvice annotation’ini kullanacagiz. Yine ilgili exceptionlari tanimlamak icin @ExceptionHandler annotation’ini kullaniyoruz.
 * Boylece tum proje kapsaminda ilgili exceptionlar firlatildiginda bu metotlar tarafindan handle edilecektir.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetailsException errorDetails = new ErrorDetailsException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceAlreadyExistsException ex, WebRequest request) {
        ErrorDetailsException errorDetails = new ErrorDetailsException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(BadResourceException.class)
    public ResponseEntity<?> resourceNotFoundException(BadResourceException ex, WebRequest request) {
        ErrorDetailsException errorDetails = new ErrorDetailsException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetailsException errorDetails = new ErrorDetailsException(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
