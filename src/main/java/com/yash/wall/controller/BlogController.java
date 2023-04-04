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
import org.springframework.web.bind.annotation.RequestParam;
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
    @PostMapping
    public ResponseEntity<HttpStatus> saveBlog(@Valid @RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // read
    @GetMapping("/count")
    public ResponseEntity<Integer> getAllBlogsCount() {
        return new ResponseEntity<>(blogService.getPublicBlogCount(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BlogDetailsVO>> getAllBlogsBuUserId() {
        return new ResponseEntity<>(blogService.findBlogDetailsForLoggedInUser(), HttpStatus.OK);
    }

    @GetMapping("/{blogid}")
    public ResponseEntity<BlogDetailsVO> getBlogByBlogId(@PathVariable int blogid) {
        return new ResponseEntity<>(blogService.findBlogDetailsByBlogId(blogid), HttpStatus.CREATED);
    }

    // update
    @PutMapping
    public ResponseEntity<HttpStatus> updateblogbyId(@Valid @RequestBody Blog blog) {
        blogService.updateBlogByBlogId(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{blogid}")
    public ResponseEntity<HttpStatus> deleteblogbyId(@PathVariable String blogid) {
        blogService.deleteBlogByBlogId(blogid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/explore")
    public ResponseEntity<List<BlogDetailsVO>> getAllPublicBlogs(@RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "1") int pageNumber) {
        return new ResponseEntity<>(blogService.findBlogsPublicBlogs(limit, pageNumber), HttpStatus.OK);
    }

    @GetMapping("/explore/{blogid}")
    public ResponseEntity<BlogDetailsVO> getPublicBlogByBlogid(@PathVariable int blogid) {
        return new ResponseEntity<>(blogService.findPublicBlogByBlogid(blogid), HttpStatus.OK);
    }

}
