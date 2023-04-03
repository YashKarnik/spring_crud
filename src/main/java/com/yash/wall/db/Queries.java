package com.yash.wall.db;

public interface Queries {

    // user
    String INSERT_USER = "INSERT INTO user_details (email, username, password) VALUES ('%s','%s','%s');";
    String GET_USER_BY_ID = "SELECT * FROM user_details WHERE userid=%s";
    String GET_USER_BY_USERNAME = "SELECT * FROM user_details WHERE username='%s'";
    String GET_USER_BY_EMAIL = "SELECT * FROM user_details WHERE email='%s'";
    String UPDATE_USER_USERNAME_BY_ID = "UPDATE user_details SET username='%s' WHERE userid=%s";
    String UPDATE_USER_PASSWORD_BY_ID = "UPDATE user_details SET password='%s' WHERE userid=%s";
    String UPDATE_USER_EMAIL_BY_ID = "UPDATE user_details SET email='%s' WHERE userid=%s";
    String DELETE_USER_BY_ID = "DELETE from user_details where userid=%s";

    // blog
    String INSERT_BLOG = "INSERT INTO blog (userid,title,content) VALUES ((SELECT DISTINCT  ud.userid AS userid FROM user_details ud JOIN blog b ON ud.userid = b.userid WHERE ud.email='%s'),'%s','%s') ";

    String GET_BLOGS_BY_USER_ID = "SELECT * FROM blog b WHERE b.userid = %s";
    String GET_BLOGS_BY_EMAIL_ID = "SELECT b.* FROM blog b JOIN user_details ud ON b.userid = ud.userid WHERE ud.email = '%s'";
    String GET_BLOG_BY_BLOG_ID = "SELECT b.* FROM blog b JOIN user_details ud ON b.userid = ud.userid WHERE ud.email = '%s' AND b.blogid =%s";

    String UPDATE_BLOG_BY_BLOGID = "UPDATE blog SET title ='%s', \"content\" = '%s' WHERE blogid=%s AND userid = (SELECT ud.userid FROM user_details ud WHERE ud.email ='%s')";
    String DELETE_BLOG_BY_BLOGID = "DELETE FROM blog WHERE blogid=%s and userid=(SELECT DISTINCT ud.userid FROM user_details ud WHERE ud.email='%s')";

    // comments
    String GET_COMMENTS_BY_BLOG_ID = "SELECT bc.*,ud.username  FROM blog_comments bc  JOIN user_details ud ON bc.userid = ud.userid WHERE bc.blogid= %s";
    String ADD_COMMENT_TO_BLOG = "INSERT INTO blog_comments ( userid, blogid ,content) VALUES ((SELECT DISTINCT  ud.userid AS userid FROM user_details ud JOIN blog b ON ud.userid = b.userid WHERE ud.email='%s'),%s,'%s')";

}
