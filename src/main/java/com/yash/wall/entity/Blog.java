package com.yash.wall.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Blog {
    private int blogid;
    @NotBlank(message = "Content cannot be blank")
    private String content;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    private int userid;
}
