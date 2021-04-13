package com.springboot.jwt.common.model;

/**
 * @author lilei
 */
public class ResponseFactory {

    private ResponseFactory(){

    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static<T> BaseResponse buildSuccessResponse(T data) {
        return buildResponse(BaseResponseCode.SUCCESS, "成功", data);
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static BaseResponse buildFailResponse(String message) {
        return buildResponse(BaseResponseCode.FAIL, message, null);
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static<T> BaseResponse buildResponse(BaseResponseCode resultCode, String message, T data) {
        return buildResponse(resultCode.getCode(), message, data);
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static<T> BaseResponse buildResponse(String resultCode, String message, T data) {
        return new BaseResponse(resultCode, message, data);
    }
}
