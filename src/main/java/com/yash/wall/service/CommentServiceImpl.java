package com.yash.wall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.wall.entity.Comment;
import com.yash.wall.exceptions.CommentNotFoundException;
import com.yash.wall.repository.CommentRepository;
import com.yash.wall.vo.CommentDetailsVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;

    @Override
    public List<CommentDetailsVO> getAllcommentsByBlogId(int blogid) {
        return commentRepository.findAllcommentsByBlogId(blogid)
                .orElseThrow(() -> new CommentNotFoundException());
    }

    @Override
    public void addCommentToBlog(Comment comment) {
        commentRepository.addCommentToBlog(comment);
    }
}
