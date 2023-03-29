package com.yash.wall.db;

public interface Queries {
    String INSERT_USER = "INSERT INTO user_details (email, username, password) VALUES ('%s','%s','%s');";
    String GET_USER_BY_ID = "SELECT * FROM user_details WHERE userid=%s";
    String GET_USER_BY_USERNAME = "SELECT * FROM user_details WHERE username='%s'";
    String GET_USER_BY_EMAIL = "SELECT * FROM user_details WHERE email='%s'";
    String UPDATE_USER_USERNAME_BY_ID = "UPDATE user_details SET username='%s' WHERE userid=%s";
    String UPDATE_USER_PASSWORD_BY_ID = "UPDATE user_details SET password='%s' WHERE userid=%s";
    String UPDATE_USER_EMAIL_BY_ID = "UPDATE user_details SET email='%s' WHERE userid=%s";
    String DELETE_USER_BY_ID = "DELETE from user_details where userid=%s";

    String INSERT_BLOG = "INSERT INTO blog (userid,title,content) VALUES (%s,'%s','%s')";
    String GET_BLOGS_BY_USER_ID = "SELECT b.* FROM user_details ud JOIN blog b ON ud.userid=b.userid WHERE ud.userid='%s'";
    String GET_BLOG_BY_BLOG_ID = "SELECT * FROM blog WHERE userid='%s' AND blogid='%s'";
    String UPDATE_BLOG_BY_BLOGID = "UPDATE blog SET title='%s',content='%s' WHERE userid='%s' AND blogid='%s'";
    String DELETE_BLOG_BY_BLOGID = "DELETE FROM blog WHERE userid=%s and blogid=%s";

}
