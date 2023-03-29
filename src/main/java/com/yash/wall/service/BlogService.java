package com.yash.wall.service;

import java.util.List;

import com.yash.wall.entity.Blog;
import com.yash.wall.vo.BlogDetailsVO;

public interface BlogService {
    void saveBlog(Blog user);

    List<BlogDetailsVO> findBlogsByUserId(int userid);

    BlogDetailsVO findBlogByBlogId(int userid, int blogid);

}
