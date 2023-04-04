package com.yash.wall.db.objectMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import com.yash.wall.entity.User;
import com.yash.wall.vo.BlogDetailsVO;
import com.yash.wall.vo.CommentDetailsVO;

public interface SQLObjectMapper {
    Optional<User> mapUser(ResultSet resultSet);

    Optional<List<User>> mapUsers(ResultSet resultSet);

    Optional<BlogDetailsVO> mapBlog(ResultSet resultSet);

    Optional<List<BlogDetailsVO>> mapBlogs(ResultSet resultSet);

    Optional<List<CommentDetailsVO>> mapComments(ResultSet resultSet);

    Optional<Integer> mapCount(ResultSet resultSet);

}
