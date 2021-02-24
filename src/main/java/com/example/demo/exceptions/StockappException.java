package com.example.demo.exceptions;

public class StockappException extends RuntimeException{

    public StockappException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public StockappException(String exMessage) {
        super(exMessage);
    }
}
