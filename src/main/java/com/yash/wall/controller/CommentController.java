package com.yash.wall.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.wall.entity.Comment;
import com.yash.wall.service.CommentService;
import com.yash.wall.vo.CommentDetailsVO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    CommentService commentService;

    // read
    @GetMapping("/{blogid}")
    public ResponseEntity<List<CommentDetailsVO>> getAllcommentsByBlogId(@PathVariable int blogid) {
        return new ResponseEntity<>(commentService.getAllcommentsByBlogId(blogid), HttpStatus.OK);
    }

    // add
    @PostMapping("/add")
    public ResponseEntity<List<CommentDetailsVO>> addCommentstoBlog(@Valid @RequestBody Comment comment) {
        commentService.addCommentToBlog(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
