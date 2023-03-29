package com.yash.wall.vo;

import java.util.Date;

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
    private Date dateCreated;
    // private Likes likes;

}
