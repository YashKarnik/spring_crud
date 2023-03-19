package com.yash.wall.service;

import org.springframework.stereotype.Service;

import com.yash.wall.entity.User;
import com.yash.wall.exceptions.IllegalRequestEntityException;
import com.yash.wall.exceptions.UserNotFoundException;
import com.yash.wall.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public User findUserById(int id) {
        return userRepository
                .getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository
                .getUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

    }

    @Override
    public void updateUserUsernameById(int id, String username) {
        userRepository.updateUserUsernameById(id, username);
    }

    @Override
    public void updateUserPasswordById(int id, String password) {
        userRepository.updateUserPasswordById(id, password);

    }

    @Override
    public void updateUser(int id, String field, User user) {

        if (field.equals("username") && user.getUsername() != null)
            userRepository.updateUserUsernameById(id, user.getUsername());
        else if (field.equals("password") && user.getPassword() != null)
            userRepository.updateUserPasswordById(id, user.getPassword());
        else if (!(user.getUsername() == null ^ user.getPassword() == null))
            throw new IllegalRequestEntityException();
        else
            throw new IllegalRequestEntityException(field);
    }

}
