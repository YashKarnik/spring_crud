package com.yash.wall.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.yash.wall.db.PostgreSqlJDBC;
import com.yash.wall.db.Queries;
import com.yash.wall.db.objectMapper.SQLObjectMapper;
import com.yash.wall.entity.Blog;
import com.yash.wall.vo.BlogDetailsVO;
import com.yash.wall.vo.CommentDetailsVO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BlogRepository {
    PostgreSqlJDBC postgreSqlJDBC;
    SQLObjectMapper sqlObjectMapper;

    // create
    public int saveBlog(Blog blog) {
        String query = String.format(Queries.INSERT_BLOG, blog.getUserid(), blog.getContent(), blog.getTitle());
        int affectedRows = postgreSqlJDBC.executeUpdate(query);
        return affectedRows;
    }

    // read
    public Optional<List<BlogDetailsVO>> getBlogsByUserId(int userid) {
        String query = String.format(Queries.GET_BLOGS_BY_USER_ID, userid);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapBlogs(result);
    }

    public Optional<BlogDetailsVO> getBlogByBlogId(int userid, int blogid) {
        String query = String.format(Queries.GET_BLOG_BY_BLOG_ID, userid, blogid);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapBlog(result);

    }

    public Optional<List<CommentDetailsVO>> getAllCommentsByBlogId(int blogid) {
        String query = String.format(Queries.GET_COMMENTS_BY_BLOG_ID, blogid);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapComments(result);
    }

    // upadte
    public void upadteBlogByBlogId(Blog blog) {
        String query = String.format(Queries.UPDATE_BLOG_BY_BLOGID, blog.getTitle(), blog.getContent(),
                blog.getUserid(), blog.getBlogid());
        postgreSqlJDBC.executeUpdate(query);
    }

    // delete
    public void deleteBlogByBlogId(Blog blog) {
        String query = String.format(Queries.DELETE_BLOG_BY_BLOGID, blog.getUserid(), blog.getBlogid());
        postgreSqlJDBC.executeUpdate(query);
    }
}
