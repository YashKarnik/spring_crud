package com.yash.wall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.wall.entity.Blog;
import com.yash.wall.exceptions.UserNotFoundException;
import com.yash.wall.repository.BlogRepository;
import com.yash.wall.vo.BlogDetailsVO;

import lombok.AllArgsConstructor;

/**
 * BlogServiceImpl
 */

@AllArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {
    BlogRepository blogRepository;

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.saveBlog(blog);
    }

    @Override
    public List<BlogDetailsVO> findBlogsByUserId(int userid) {
        return blogRepository.getBlogByUserId(userid).orElseThrow(() -> new UserNotFoundException("test"));

    }
}