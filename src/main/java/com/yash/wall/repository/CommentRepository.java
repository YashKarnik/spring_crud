package com.yash.wall.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.yash.wall.db.PostgreSqlJDBC;
import com.yash.wall.db.Queries;
import com.yash.wall.db.objectMapper.SQLObjectMapper;
import com.yash.wall.entity.Comment;
import com.yash.wall.vo.CommentDetailsVO;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CommentRepository {
    PostgreSqlJDBC postgreSqlJDBC;
    SQLObjectMapper sqlObjectMapper;

    // read
    public Optional<List<CommentDetailsVO>> findAllcommentsByBlogId(int blogid) {
        String query = String.format(Queries.GET_COMMENTS_BY_BLOG_ID, blogid);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapComments(result);
    }

    // create
    public void addCommentToBlog(String emailId, Comment comment) {
        String query = String.format(Queries.ADD_COMMENT_TO_BLOG, emailId, comment.getBlogid(), comment.getContent());
        postgreSqlJDBC.executeUpdate(query);
    }
}
