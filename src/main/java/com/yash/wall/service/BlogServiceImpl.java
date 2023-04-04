package com.yash.wall.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.yash.wall.entity.Blog;
import com.yash.wall.exceptions.BlogNotFoundException;
import com.yash.wall.exceptions.DatabaseConnectionException;
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
        String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
        blogRepository.saveBlog(emailId, blog.getContent(), blog.getTitle());
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
    public BlogDetailsVO findBlogDetailsByBlogId(int blogid) {
        String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
        List<CommentDetailsVO> comments = blogRepository.getAllCommentsByBlogId(blogid)
                .orElseThrow(() -> new BlogNotFoundException(blogid));
        BlogDetailsVO blog = blogRepository.getBlogByBlogId(emailId, blogid)
                .orElseThrow(() -> new BlogNotFoundException(blogid));
        blog.setCommentDetailsVO(comments);
        return blog;
    }

    @Override
    public List<BlogDetailsVO> findBlogsPublicBlogs(int limit, int pageNumber) {
        int offest = limit * (pageNumber - 1);
        return blogRepository.getAllPublicBlogs(limit, offest).orElseThrow(() -> new DatabaseConnectionException());
    }

    @Override
    public Integer getPublicBlogCount() {
        return blogRepository.getAllPublicBlogCount().orElseThrow(() -> new DatabaseConnectionException());
    }

    @Override
    public BlogDetailsVO findPublicBlogByBlogid(int blogid) {
        List<CommentDetailsVO> comments = blogRepository.getAllCommentsByBlogId(blogid)
                .orElseThrow(() -> new BlogNotFoundException(blogid));
        BlogDetailsVO blog = blogRepository.getPublicBlogByBlogId(blogid)
                .orElseThrow(() -> new DatabaseConnectionException());
        blog.setCommentDetailsVO(comments);
        return blog;
    }

    @Override
    public void updateBlogByBlogId(Blog blog) {
        String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
        blogRepository.upadteBlogByBlogId(emailId, blog.getBlogid(), blog.getTitle(), blog.getContent());
    }

    @Override
    public void deleteBlogByBlogId(String blogid) {
        String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
        blogRepository.deleteBlogByBlogId(emailId, blogid);
    }

}