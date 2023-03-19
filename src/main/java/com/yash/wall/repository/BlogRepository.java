package com.yash.wall.repository;

import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.yash.wall.db.PostgreSqlJDBC;
import com.yash.wall.db.Queries;
import com.yash.wall.db.objectMapper.SQLObjectMapper;
import com.yash.wall.entity.Blog;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class BlogRepository {
    PostgreSqlJDBC postgreSqlJDBC;
    SQLObjectMapper sqlObjectMapper;

    public Optional<Blog> getBlogById(int id) {
        String query = String.format(Queries.GET_BLOG_BY_ID, id);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return null;
        // return sqlObjectMapper.mapUser(result);
    }

}
