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

import com.yash.wall.entity.Blog;
import com.yash.wall.service.BlogService;
import com.yash.wall.vo.BlogDetailsVO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/blog")
public class BlogController {
    BlogService blogService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveBlog(@Valid @RequestBody Blog blog) {
        System.out.println("s");
        blogService.saveBlog(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<BlogDetailsVO>> getBlog(@PathVariable int id) {
        return new ResponseEntity<>(blogService.findBlogsByUserId(id), HttpStatus.CREATED);
    }

}
