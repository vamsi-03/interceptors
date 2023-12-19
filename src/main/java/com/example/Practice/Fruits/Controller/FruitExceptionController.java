package com.example.Practice.Fruits.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Practice.Fruits.FruitNotFoundException;

@ControllerAdvice
public class FruitExceptionController
{
    @ExceptionHandler(value = FruitNotFoundException.class)
    public ResponseEntity<Object> exception (FruitNotFoundException e)
    {
        return new ResponseEntity<>("Fruit not found!", HttpStatus.NOT_FOUND);
    }
}
