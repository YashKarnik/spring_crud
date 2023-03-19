package com.yash.wall.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.wall.entity.User;
import com.yash.wall.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    // create
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> saveuser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // read
    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findUserById(id).getUsername(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateUser(@PathVariable int id, @RequestBody User user,
            @RequestParam String field) {
        userService.updateUser(id, field, user);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
