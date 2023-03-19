package com.yash.wall.db.objectMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import com.yash.wall.entity.Blog;
import com.yash.wall.entity.User;

public interface SQLObjectMapper {
    Optional<User> mapUser(ResultSet resultSet);

    Optional<List<User>> mapUsers(ResultSet resultSet);

    // Optional<Blog> mapBlog(ResultSet resultSet);
}
