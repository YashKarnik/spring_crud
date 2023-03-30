package com.yash.wall.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BlogDetailsVO {
    private final int blogid;
    private final int userid;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private Date dateCreated;
    private List<CommentDetailsVO> commentDetailsVO;

}
