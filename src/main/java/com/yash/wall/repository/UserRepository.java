package com.yash.wall.repository;

import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.yash.wall.db.PostgreSqlJDBC;
import com.yash.wall.db.Queries;
import com.yash.wall.db.objectMapper.SQLObjectMapper;
import com.yash.wall.entity.User;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserRepository {

    PostgreSqlJDBC postgreSqlJDBC;
    SQLObjectMapper sqlObjectMapper;

    public void saveUser(User user) {
        String query = String.format(Queries.INSERT_USER, user.getUsername(), user.getPassword());
        postgreSqlJDBC.executeQuery(query);

    }

    public Optional<User> getUserById(int id) {
        String query = String.format(Queries.GET_USER_BY_ID, id);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapUser(result);

    }

    public Optional<User> getUserByUsername(String username) {
        String query = String.format(Queries.GET_USER_BY_USERNAME, username);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapUser(result);
    }

    // public void updateUser(User user) {
    // String query = String.format(Queries.UPADTE_USER_BY_ID, user.getUsername(),
    // user.getPassword(), user.getId());
    // postgreSqlJDBC.executeQuery(query);
    // }

    public void updateUserUsernameById(int id, String username) {
        String query = String.format(Queries.UPDATE_USER_USERNAME_BY_ID, username, id);
        postgreSqlJDBC.executeQuery(query);
    }

    public void updateUserPasswordById(int id, String password) {
        String query = String.format(Queries.UPDATE_USER_PASSWORD_BY_ID, password, id);
        postgreSqlJDBC.executeQuery(query);
    }

    public void updateUser(int id, String field, User user) {

    }

}
