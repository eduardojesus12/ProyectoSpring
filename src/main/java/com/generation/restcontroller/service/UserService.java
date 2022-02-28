package com.generation.restcontroller.service;

import com.generation.restcontroller.model.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    List<User> getUsers();

    User save(User user);

    void delete(Long id);
}
