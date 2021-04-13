package com.springboot.jwt.auth.dao;

import com.springboot.jwt.auth.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDTOMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void addUser() {
        UserDTO userDTO =  userMapper.isExistUser("admin");
        if(userDTO !=null) {
            assertNotNull(userDTO);
            return;
        }
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(UUID.randomUUID().toString());
        userDTO2.setPassword("admin");
        userDTO2.setUserName("admin");
        userDTO2.setName("admin");
        userDTO2.setCompanyId(UUID.randomUUID().toString());
        int i = userMapper.addUser(userDTO2);
        assertEquals(1,i);
    }

}