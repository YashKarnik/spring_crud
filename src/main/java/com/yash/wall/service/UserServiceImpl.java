package com.yash.wall.service;

import org.springframework.stereotype.Service;

import com.yash.wall.entity.User;
import com.yash.wall.exceptions.IllegalRequestEntityException;
import com.yash.wall.exceptions.UserNotFoundException;
import com.yash.wall.repository.UserRepository;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public User findUserById(int id) {
        return userRepository
                .getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    @Override
    public User findUserByEmail(String username) {
        return userRepository
                .getUserByEmail(username)
                .orElseThrow(() -> new UserNotFoundException(username));

    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
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

        @Email(message = "asdfghjkl")
        String email = user.getEmail();
        String password = user.getPassword();
        String username = user.getUsername();

        if (field.equals("username")) {
            if (username != null) {
                int affectedRows = userRepository.updateUserUsernameById(id, username);
                if (affectedRows <= 0)
                    throw new UserNotFoundException(id);
            } else
                throw new IllegalRequestEntityException();

        } else if (field.equals("password")) {
            if (password != null) {
                int affectedRows = userRepository.updateUserPasswordById(id, password);
                if (affectedRows <= 0)
                    throw new UserNotFoundException(id);
            } else
                throw new IllegalRequestEntityException();
        } else if (field.equals("email")) {
            if (email != null) {
                int affectedRows = userRepository.updateUserEmailById(id, email);
                if (affectedRows <= 0)
                    throw new UserNotFoundException(id);
            } else
                throw new IllegalRequestEntityException();
        } else
            throw new IllegalRequestEntityException(field);

    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteuser(id);
    }

}
