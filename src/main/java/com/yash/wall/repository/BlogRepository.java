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
    public Optional<List<BlogDetailsVO>> getBlogByUserId(int userid) {
        String query = String.format(Queries.GET_BLOG_BY_USER_ID, userid);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapBlogs(result);
    }

}
