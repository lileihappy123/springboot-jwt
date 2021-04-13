package com.springboot.jwt.auth.model;

import lombok.Data;

@Data
public class BaseUser {
    private String id;

    private String name;

    private String userName;
}
