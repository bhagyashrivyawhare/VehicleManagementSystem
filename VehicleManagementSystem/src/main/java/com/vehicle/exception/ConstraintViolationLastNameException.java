package com.vehicle.exception;

public class ConstraintViolationLastNameException extends  RuntimeException{
    public ConstraintViolationLastNameException(String message){
        super(message);
    }
}
