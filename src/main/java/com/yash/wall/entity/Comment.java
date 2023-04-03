package com.yash.wall.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Comment {
    private int commentid;
    @Positive(message = "Illegal id")
    private int blogid;
    private int userid;
    @NotNull(message = "Comment cannot be blank")
    private String content;
}
