package com.springboot.jwt.common.advice;

import com.springboot.jwt.common.model.BaseResponseCode;
import com.springboot.jwt.common.exception.CustomException;
import com.springboot.jwt.common.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lilei
 */
@RestControllerAdvice
@Slf4j
public class GlobalDefultExceptionHandler {
    /**
     * 处理参数异常，一般用于校验body参数
     *
     * @param e 异常对象
     * @return 返回值对象ß
     */
    @ExceptionHandler(CustomException.class)
    public BaseResponse<String> handleValidationBodyException(CustomException e) {
        e.printStackTrace();
        return new BaseResponse<>(BaseResponseCode.INTERNAL_SERVER_ERROR.getCode(), e.getMessage(),"");
    }

    /**
     * 主动throw的异常
     *
     * @param e 异常对象ß
     * @param response 返回值对象
     * @return 返回值对象
     */
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<String> handleUnProccessableServiceException(RuntimeException e, HttpServletResponse response) {
        e.printStackTrace();
        return new BaseResponse<>(BaseResponseCode.INTERNAL_SERVER_ERROR.getCode(), e.getMessage(),"");
    }
}
