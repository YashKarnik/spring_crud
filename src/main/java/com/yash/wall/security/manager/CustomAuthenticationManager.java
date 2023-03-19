package com.yash.wall.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.yash.wall.entity.User;
import com.yash.wall.service.UserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        User user = userService.findUserByUsername(authentication.getPrincipal().toString());

        if (!user.getPassword().equals(authentication.getCredentials()))
            throw new BadCredentialsException("Incorrect password");

        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    }
}
