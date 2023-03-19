package com.yash.wall.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super(String.format(ExceptionMessages.USERNAME_NOT_FOUND, username));
    }

    public UserNotFoundException(int id) {
        super(String.format(ExceptionMessages.USERID_NOT_FOUND, id));
    }

}