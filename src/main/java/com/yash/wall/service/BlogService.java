package com.yash.wall.service;

import java.util.List;

import com.yash.wall.entity.Blog;
import com.yash.wall.vo.BlogDetailsVO;

public interface BlogService {
    void saveBlog(Blog blog);

    List<BlogDetailsVO> findBlogsByUserId(int userid);

    BlogDetailsVO findBlogDetailsByBlogId(int blogid);

    List<BlogDetailsVO> findBlogDetailsForLoggedInUser();

    void updateBlogByBlogId(Blog blog);

    void deleteBlogByBlogId(String blogid);

}
