package com.yash.wall.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.yash.wall.entity.Blog;
import com.yash.wall.exceptions.BlogNotFoundException;
import com.yash.wall.exceptions.UserNotFoundException;
import com.yash.wall.repository.BlogRepository;
import com.yash.wall.vo.BlogDetailsVO;
import com.yash.wall.vo.CommentDetailsVO;

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
        return blogRepository.getBlogsByUserId(userid).orElseThrow(() -> new UserNotFoundException(userid));

    }

    @Override
    public List<BlogDetailsVO> findBlogDetailsForLoggedInUser() {
        String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
        return blogRepository.getBlogsByEmailId(emailId).orElseThrow(() -> new UserNotFoundException(emailId));

    }

    @Override
    public BlogDetailsVO findBlogDetailsByBlogId(int userid, int blogid) {
        List<CommentDetailsVO> comments = blogRepository.getAllCommentsByBlogId(blogid)
                .orElseThrow(() -> new BlogNotFoundException(blogid));
        BlogDetailsVO blog = blogRepository.getBlogByBlogId(userid, blogid)
                .orElseThrow(() -> new BlogNotFoundException(blogid));
        blog.setCommentDetailsVO(comments);
        return blog;
    }

    @Override
    public void updateBlogByBlogId(Blog blog) {
        blogRepository.upadteBlogByBlogId(blog);
    }

    @Override
    public void deleteBlogByBlogId(Blog blog) {
        blogRepository.deleteBlogByBlogId(blog);
    }

}