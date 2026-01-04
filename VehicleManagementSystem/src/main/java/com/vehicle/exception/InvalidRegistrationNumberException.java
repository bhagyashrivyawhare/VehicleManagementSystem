package com.vehicle.exception;

public class InvalidRegistrationNumberException extends  RuntimeException{
    public InvalidRegistrationNumberException(String msg){
        super(msg);
    }
}
