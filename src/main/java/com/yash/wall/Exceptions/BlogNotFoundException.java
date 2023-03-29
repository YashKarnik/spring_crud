package com.yash.wall.exceptions;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(int id) {
        super(String.format(ExceptionMessages.BLOGID_NOT_FOUND, id));
    }
}
