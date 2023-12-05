package com.example.exerciserepository.API;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
