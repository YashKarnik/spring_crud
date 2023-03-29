package com.yash.wall.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.yash.wall.exceptions.DatabaseConnectionException;
import com.yash.wall.exceptions.NoRowsAffected;

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

    public int executeUpdate(String query) {
        try {
            Statement statement = this.getConnection().createStatement();
            int affectedRows = statement.executeUpdate(query);
            if (affectedRows <= 0)
                throw new NoRowsAffected();
            return affectedRows;
        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            System.out.println(query);
            Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;

        } catch (SQLException se) {
            throw new DatabaseConnectionException(se);
        }
    }
}