package com.yash.wall.db.objectMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import com.yash.wall.entity.User;
import com.yash.wall.vo.BlogDetailsVO;

public interface SQLObjectMapper {
    Optional<User> mapUser(ResultSet resultSet);

    Optional<List<User>> mapUsers(ResultSet resultSet);

    Optional<BlogDetailsVO> mapBlog(ResultSet resultSet);

    Optional<List<BlogDetailsVO>> mapBlogs(ResultSet resultSet);
}
