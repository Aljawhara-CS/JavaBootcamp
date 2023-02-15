package com.example.javabootcamphw28.Advise;


import com.example.javabootcamphw28.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ControllerAdvise {

    @ExceptionHandler (value= ApiException.class)
    public ResponseEntity ApiException(ApiException e){

        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler (value= MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){

        String message=e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }


}
