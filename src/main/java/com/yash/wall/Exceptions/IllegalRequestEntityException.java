package com.yash.wall.exceptions;

public class IllegalRequestEntityException extends RuntimeException {
    public IllegalRequestEntityException(String param) {
        super("Illegal request keyword <" + param + "> passed");
    }

    public IllegalRequestEntityException() {
        super("Illegal request keyword was passed in request body");
    }
}
