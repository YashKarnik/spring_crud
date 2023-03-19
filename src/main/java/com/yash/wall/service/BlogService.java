package com.yash.wall.service;

import com.yash.wall.entity.Blog;

public interface BlogService {
    void saveBlog(Blog user);

    Blog findBlogById(int id);

}
