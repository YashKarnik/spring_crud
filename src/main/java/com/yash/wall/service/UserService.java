package com.yash.wall.service;

import com.yash.wall.entity.User;

public interface UserService {
    // Create
    void saveUser(User user);

    // read
    User findUserById(int id);

    User findUserByEmail(String username);

    // update

    void updateUserUsernameById(int id, String username);

    void updateUserPasswordById(int id, String password);

    void updateUser(int id, String field, User user);

    // delete
    void deleteUserById(int id);

}
