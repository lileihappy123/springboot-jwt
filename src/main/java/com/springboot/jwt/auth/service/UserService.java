package com.springboot.jwt.auth.service;


import com.springboot.jwt.auth.model.UserDTO;
import com.springboot.jwt.auth.model.UserVO;
import com.springboot.jwt.auth.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务层
 * @author lilei
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserService(){

    }

    public int addUser(UserDTO userDTO){
      return userMapper.addUser(userDTO);
    }

    public UserDTO getUserById(String id){
        return userMapper.getUserById(id);
    }

    public UserDTO getUserByUserName(String userName){
        return userMapper.queryInfoByUserName(userName);
    }

    public UserVO login(String userName, String password){
        return userMapper.login(userName,password);
    }
}