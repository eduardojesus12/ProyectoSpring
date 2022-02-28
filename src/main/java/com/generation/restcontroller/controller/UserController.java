package com.generation.restcontroller.controller;

import com.generation.restcontroller.model.User;
import com.generation.restcontroller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
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
