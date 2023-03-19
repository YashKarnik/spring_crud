package com.yash.wall.db;

public interface Queries {
    String INSERT_USER = "INSERT INTO users (username,user_password) VALUES ('%s','%s');";
    String GET_USER_BY_ID = "SELECT * FROM users WHERE id=%s";
    String GET_USER_BY_USERNAME = "SELECT * FROM users WHERE username='%s'";
    String GET_BLOG_BY_ID = "SELECT * FROM blogs WHERE id=%s";
    String UPDATE_USER_USERNAME_BY_ID = "UPDATE users SET username='%s' WHERE id=%s";
    String UPDATE_USER_PASSWORD_BY_ID = "UPDATE users SET user_password='%s' WHERE id=%s";

}
