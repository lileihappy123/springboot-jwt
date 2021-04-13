package com.springboot.jwt.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户类
 * @author lilei
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends BaseUser {

    private String password;

    private String companyId;
}