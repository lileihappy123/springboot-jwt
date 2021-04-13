package com.springboot.jwt.common.model;

/**
 * @author lilei
 */

public enum BaseResponseCode {
    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 失败
     */
    FAIL(400),

    /**
     * 未认证（签名错误）
     */
    UNAUTHORIZED(401),

    /**
     * 接口不存在
     */
    NOT_FOUND(404),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500);

    private final String code;

    BaseResponseCode(int code) {
        this.code = code+"";
    }

    public String getCode(){
        return this.code;
    }

}
