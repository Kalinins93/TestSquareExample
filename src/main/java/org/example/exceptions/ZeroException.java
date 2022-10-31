package org.example.exceptions;

public class ZeroException extends RuntimeException {

    private static final String message = "You can’t divide into zero";

    public ZeroException(){
        super(message);
    }

}
