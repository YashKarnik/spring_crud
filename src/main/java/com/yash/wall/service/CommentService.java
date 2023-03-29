package com.yash.wall.service;

import java.util.List;

import com.yash.wall.entity.Comment;
import com.yash.wall.vo.CommentDetailsVO;

public interface CommentService {
    public List<CommentDetailsVO> getAllcommentsByBlogId(int blogid);

    public void addCommentToBlog(Comment comment);
}
