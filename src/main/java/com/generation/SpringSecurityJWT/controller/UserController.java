package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.User;
import com.generation.SpringSecurityJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(@Autowired UserService userService,@Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


    @GetMapping("/all")
    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userService.getUsers();
    }
}
