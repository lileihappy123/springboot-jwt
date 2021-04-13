package com.springboot.jwt.common.model;

/**
 * @author lilei
 */

public enum BaseResponseMsg {
    INVALIDED_TOKEN("Token 不合法"),
    INVALIDED_USER("用户名或密码错误"),
    INTERNAL_SERVER_ERROR("服务器内部错误");
    private final String msg;
    BaseResponseMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
}
