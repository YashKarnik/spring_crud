package com.yash.wall.Exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private List<String> messages;

    public ErrorResponse(List<String> messages) {
        this.timestamp = LocalDateTime.now();
        this.messages = messages;
    }

    public ErrorResponse(String message) {
        this.timestamp = LocalDateTime.now();
        this.messages = Arrays.asList(message);
    }

}
