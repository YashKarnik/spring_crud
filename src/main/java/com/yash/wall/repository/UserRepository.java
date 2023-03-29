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
        String query = String.format(Queries.INSERT_USER, user.getEmail(), user.getUsername(), user.getPassword());
        postgreSqlJDBC.executeUpdate(query);

    }

    public Optional<User> getUserById(int id) {
        String query = String.format(Queries.GET_USER_BY_ID, id);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapUser(result);

    }

    public Optional<User> getUserByEmail(String email) {
        String query = String.format(Queries.GET_USER_BY_EMAIL, email);
        ResultSet result = postgreSqlJDBC.executeQuery(query);
        return sqlObjectMapper.mapUser(result);
    }

    public int updateUserUsernameById(int id, String username) {
        String query = String.format(Queries.UPDATE_USER_USERNAME_BY_ID, username, id);
        return postgreSqlJDBC.executeUpdate(query);
    }

    public int updateUserPasswordById(int id, String password) {
        String query = String.format(Queries.UPDATE_USER_PASSWORD_BY_ID, password, id);
        return postgreSqlJDBC.executeUpdate(query);
    }

    public int updateUserEmailById(int id, String email) {
        String query = String.format(Queries.UPDATE_USER_EMAIL_BY_ID, email, id);
        return postgreSqlJDBC.executeUpdate(query);
    }

    public void deleteuser(int id) {
        String query = String.format(Queries.DELETE_USER_BY_ID, id);
        postgreSqlJDBC.executeUpdate(query);
    }

}
