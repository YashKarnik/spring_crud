package com.yash.wall.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Blog {
    private int id;
    @NotBlank(message = "Content cannot be blank")
    private String content;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @PositiveOrZero(message = "Likes cannot be negative")
    @NotBlank(message = "Title cannot be blank")
    private int likes;
}
