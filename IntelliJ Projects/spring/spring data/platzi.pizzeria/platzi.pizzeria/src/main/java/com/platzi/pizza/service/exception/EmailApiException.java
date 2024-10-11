package com.platzi.pizza.service.exception;

//Exception Class
public class EmailApiException extends  RuntimeException {

    // Is a try
    public EmailApiException() {
        super("Error sending Email...");
    }
}
