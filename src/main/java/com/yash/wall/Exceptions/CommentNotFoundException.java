package com.yash.wall.exceptions;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException() {
        super("Comment not founr :(");
    }
}
