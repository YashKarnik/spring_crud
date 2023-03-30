package com.yash.wall.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // create
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveBlog(@Valid @RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // read
    @GetMapping("/{userid}")
    public ResponseEntity<List<BlogDetailsVO>> getAllBlogsBuUserId(@PathVariable int userid) {
        return new ResponseEntity<>(blogService.findBlogsByUserId(userid), HttpStatus.CREATED);
    }

    @GetMapping("/{userid}/{blogid}")
    public ResponseEntity<BlogDetailsVO> getBlogByBlogId(@PathVariable int userid, @PathVariable int blogid) {
        return new ResponseEntity<>(blogService.findBlogDetailsByBlogId(userid, blogid), HttpStatus.CREATED);
    }

    // update
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateblogbyId(@Valid @RequestBody Blog blog) {
        blogService.updateBlogByBlogId(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteblogbyId(@Valid @RequestBody Blog blog) {
        blogService.deleteBlogByBlogId(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
