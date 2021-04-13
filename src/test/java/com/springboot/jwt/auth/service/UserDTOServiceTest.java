package com.springboot.jwt.auth.service;

import com.springboot.jwt.auth.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserDTOServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void addUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(UUID.randomUUID().toString());
        userDTO.setPassword("this is a pwd");
        int i = userService.addUser(userDTO);
        assertEquals(1,i);

    }
}