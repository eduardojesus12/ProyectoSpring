package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.User;
import com.generation.SpringSecurityJWT.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    @DisplayName("Pruebas UserController save")
    void saveTest() {
        UserService userService = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
        UserController userController = new UserController(userService, bCryptPasswordEncoder);

        User user = new User();
        user.setName("Carlos Eduardo");
        user.setEmail("carlos@hotmail.com");
        user.setPassword("12345678");

        when(userService.save(any(User.class))).thenReturn(user);
        User response = userController.saveUser(user);

        verify(userService, times(1)).save(any(User.class));
        verify(bCryptPasswordEncoder, atLeastOnce()).encode("12345678");

        assertEquals(user.getName(), response.getName());
    }

    @Test
    @DisplayName("Pruebas en getUser")
    void getUserTest() {
        UserService userService = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);

        UserController userController = new UserController(userService, bCryptPasswordEncoder);

        // Verificar que se haya llamado el servicio
        // Verificar que el servicio nos devuelva un objeto User

        User user = new User();
        user.setName("Carlos Eduardo");
        user.setEmail("carlos@hotmail.com");
        user.setPassword("12345678");
        user.setId(1L);

        when(userService.getUser(user.getId())).thenReturn(user);
        User response = userController.saveUser(user);

        verify(userService, times(1)).save(any(User.class));
        assertEquals(user.getName(), response.getName());



    }

}