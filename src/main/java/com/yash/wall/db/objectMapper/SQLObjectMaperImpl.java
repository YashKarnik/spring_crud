package com.yash.wall.db.objectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.yash.wall.Exceptions.DatabaseConnectionException;
import com.yash.wall.entity.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SQLObjectMaperImpl implements SQLObjectMapper {
    @Override
    public Optional<List<User>> mapUsers(ResultSet resultSet) {
        try {
            List<User> users = new ArrayList<User>();
            while (resultSet != null && resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("user_password");
                User user = new User(id, username, password);
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
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("user_password");
                User user = new User(id, username, password);
                return Optional.ofNullable(user);
            }
            return Optional.empty();
        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }
}
