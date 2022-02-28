package com.generation.SpringSecurityJWT.service;

import com.generation.SpringSecurityJWT.model.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    List<User> getUsers();

    User save(User user);

    void delete(Long id);
}
