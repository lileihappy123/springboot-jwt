package com.springboot.jwt.base.controller;

import com.springboot.jwt.common.annotation.PassToken;
import com.springboot.jwt.common.annotation.UserLoginToken;
import com.springboot.jwt.common.model.BaseResponse;
import com.springboot.jwt.common.model.ResponseFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author lilei
 */
@RestController
@ApiIgnore
public class HelloController {

    @PassToken
    @GetMapping("/hi")
    @ApiOperation(value = "",hidden = true)
    public String sayHi() {
        return "Hi";
    }

    @UserLoginToken
    @GetMapping("/hi2")
    @ApiOperation(value = "",hidden = true)
    @SuppressWarnings({"unchecked"})
    public BaseResponse<String> sayHi2() {
        return ResponseFactory.buildSuccessResponse("Successfully");
    }
}
