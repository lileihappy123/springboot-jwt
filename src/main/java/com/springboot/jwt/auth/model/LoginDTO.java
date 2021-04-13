package com.springboot.jwt.auth.model;

import lombok.Data;

/**
 * 用户登录类
 * @author lilei
 */
@Data
public class LoginDTO  {

    private String userName;

    private String password;

}