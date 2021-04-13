package com.springboot.jwt.common.model;

import lombok.Data;

/**
 * @author lilei
 */
@Data
public class BaseResponse<T> {
    private String code;
    private String msg;
    private T data;
    public BaseResponse(String code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
