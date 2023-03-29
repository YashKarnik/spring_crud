package com.yash.wall.db.objectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.yash.wall.entity.User;
import com.yash.wall.exceptions.DatabaseConnectionException;
import com.yash.wall.vo.BlogDetailsVO;
import com.yash.wall.vo.CommentDetailsVO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SQLObjectMaperImpl implements SQLObjectMapper {
    @Override
    public Optional<List<User>> mapUsers(ResultSet resultSet) {
        try {
            List<User> users = new ArrayList<User>();
            while (resultSet != null && resultSet.next()) {
                int id = resultSet.getInt("userid");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id, username, password, email);
                users.add(user);
            }
            return Optional.ofNullable(users);

        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }

    @Override
    public Optional<User> mapUser(ResultSet resultSet) {
        try {
            while (resultSet != null && resultSet.next()) {
                int id = resultSet.getInt("userid");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id, username, password, email);
                return Optional.ofNullable(user);
            }
            return Optional.empty();
        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }

    @Override
    public Optional<BlogDetailsVO> mapBlog(ResultSet resultSet) {

        try {
            while (resultSet != null && resultSet.next()) {
                int blogid = resultSet.getInt("blogid");
                int userid = resultSet.getInt("userid");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Date dateCreated = resultSet.getTimestamp("created_at");
                BlogDetailsVO blogdetails = new BlogDetailsVO(blogid, userid, title, content, dateCreated);
                return Optional.ofNullable(blogdetails);
            }
            return Optional.empty();
        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }

    public Optional<List<BlogDetailsVO>> mapBlogs(ResultSet resultSet) {
        List<BlogDetailsVO> blogs = new ArrayList<BlogDetailsVO>();
        try {
            while (resultSet != null && resultSet.next()) {
                int blogid = resultSet.getInt("blogid");
                int userid = resultSet.getInt("userid");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Date dateCreated = resultSet.getTimestamp("created_at");
                BlogDetailsVO blogdetails = new BlogDetailsVO(blogid, userid, title, content, dateCreated);
                blogs.add(blogdetails);
            }
            return Optional.ofNullable(blogs);
        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }

    public Optional<List<CommentDetailsVO>> mapComments(ResultSet resultSet) {
        List<CommentDetailsVO> comments = new ArrayList<CommentDetailsVO>();
        try {
            while (resultSet != null && resultSet.next()) {
                int blogid = resultSet.getInt("blogid");
                int userid = resultSet.getInt("userid");
                int commentid = resultSet.getInt("commentid");
                String content = resultSet.getString("content");
                Date dateCreated = resultSet.getTimestamp("created_at");
                CommentDetailsVO commentDetailsVO = new CommentDetailsVO(commentid, blogid, userid, content,
                        dateCreated);
                comments.add(commentDetailsVO);
            }
            return Optional.ofNullable(comments);
        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }
}
