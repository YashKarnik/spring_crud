package com.yash.wall.service;

import java.util.List;

import com.yash.wall.entity.Blog;
import com.yash.wall.vo.BlogDetailsVO;

public interface BlogService {
    void saveBlog(Blog blog);

    List<BlogDetailsVO> findBlogsByUserId(int userid);

    List<BlogDetailsVO> findBlogsPublicBlogs(int limit, int pageNumber);

    BlogDetailsVO findPublicBlogByBlogid(int blogid);

    BlogDetailsVO findBlogDetailsByBlogId(int blogid);

    List<BlogDetailsVO> findBlogDetailsForLoggedInUser();

    Integer getPublicBlogCount();

    void updateBlogByBlogId(Blog blog);

    void deleteBlogByBlogId(String blogid);

}
