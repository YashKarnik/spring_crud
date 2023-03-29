package com.yash.wall.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentDetailsVO {
    private int commentid;
    private int blogid;
    private int userid;
    private String content;
    private Date dateCreated;
}
