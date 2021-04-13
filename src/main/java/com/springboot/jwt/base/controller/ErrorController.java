package com.springboot.jwt.base.controller;

import com.springboot.jwt.common.model.ApiErrorResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author lilei
 * Filter 的全局异常处理
 */
@RestController
@ApiIgnore
public class ErrorController extends BasicErrorController {
    public ErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @ApiOperation(value = "",hidden = true)
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.EXCEPTION,ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.STACK_TRACE,ErrorAttributeOptions.Include.BINDING_ERRORS));
        HttpStatus status = getStatus(request);
        // 获取错误信息
        String code = errorAttributes.get("status").toString();
        String message = errorAttributes.get("message").toString();

        ApiErrorResult apiErrorResult = new ApiErrorResult(false,code,message);
        return new ResponseEntity<>(apiErrorResult,status);
    }
}
