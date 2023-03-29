package com.yash.wall.exceptions;

public class NoRowsAffected extends RuntimeException {
    public NoRowsAffected() {
        super("No rows affected");
    }
}
