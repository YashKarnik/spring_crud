package com.yash.wall.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlogDetailsVO {
    private int blogid;
    private int userid;
    private String title;
    private String content;
    private String dateCreated;
    // private Likes likes;

}
