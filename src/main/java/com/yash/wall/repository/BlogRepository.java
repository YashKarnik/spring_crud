package com.yash.wall.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.yash.wall.db.PostgreSqlJDBC;
import com.yash.wall.db.Queries;
import com.yash.wall.db.objectMapper.SQLObjectMapper;
import com.yash.wall.vo.BlogDetailsVO;
import com.yash.wall.vo.CommentDetailsVO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BlogRepository {
    PostgreSqlJDBC postgreSqlJDBC;
    SQLObjectMapper sqlObjectMapper;

    // create
    public int saveBlog(String email, String content, String title) {
        String query = String.format(Queries.INSERT_BLOG, email, content, title);
        int affectedRows = postgreSqlJDBC.executeUpdate(query);
        return affectedRows;
    }

    // read
    public Optional<List<BlogDetailsVO>> getBlogsByUserId(int userid) {
        String query = String.format(Queries.GET_BLOGS_BY_USER_ID, userid);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapBlogs(result);
    }

    public Optional<List<BlogDetailsVO>> getBlogsByEmailId(String emailId) {
        String query = String.format(Queries.GET_BLOGS_BY_EMAIL_ID, emailId);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapBlogs(result);
    }

    public Optional<BlogDetailsVO> getBlogByBlogId(String email, int blogid) {
        String query = String.format(Queries.GET_BLOG_BY_BLOG_ID, email, blogid);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapBlog(result);

    }

    public Optional<List<CommentDetailsVO>> getAllCommentsByBlogId(int blogid) {
        String query = String.format(Queries.GET_COMMENTS_BY_BLOG_ID, blogid);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapComments(result);
    }

    // upadte
    public void upadteBlogByBlogId(String email, int blogid, String title, String content) {
        String query = String.format(Queries.UPDATE_BLOG_BY_BLOGID, title, content, blogid, email);
        postgreSqlJDBC.executeUpdate(query);
    }

    // delete
    public void deleteBlogByBlogId(String email, String blogid) {
        String query = String.format(Queries.DELETE_BLOG_BY_BLOGID, blogid, email);
        postgreSqlJDBC.executeUpdate(query);
    }
}
