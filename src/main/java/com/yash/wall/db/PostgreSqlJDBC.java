package com.yash.wall.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.yash.wall.Exceptions.DatabaseConnectionException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PostgreSqlJDBC {

    // @Value("${postgres.db_url}")
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    // @Value("${postgres.user}")
    private final String user = "postgres";
    // @Value("${postgres.pass}")
    private final String pass = "admin";
    // @Value("${postgres.driver}")
    private final String driver = "org.postgresql.Driver";

    public Connection getConnection() {
        try {
            Connection conn = null;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            return conn;

        } catch (ClassNotFoundException cnfe) {
            throw new DatabaseConnectionException(cnfe);

        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            System.out.println(query);
            Statement statement = this.getConnection().createStatement();
            if (query.startsWith("SELECT")) {
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet;
            } else {
                statement.executeUpdate(query);
                return null;
            }

        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }
}