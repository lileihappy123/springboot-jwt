package com.springboot.jwt.auth.controller;

import com.springboot.jwt.auth.model.LoginDTO;
import com.springboot.jwt.auth.model.UserDTO;
import com.springboot.jwt.auth.model.UserVO;
import com.springboot.jwt.auth.service.UserService;
import com.springboot.jwt.common.annotation.PassToken;
import com.springboot.jwt.common.annotation.UserLoginToken;
import com.springboot.jwt.common.model.BaseResponse;
import com.springboot.jwt.common.model.BaseResponseMsg;
import com.springboot.jwt.common.model.ResponseFactory;
import com.springboot.jwt.common.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author lilei
 */
@Api(tags = "用户认证相关接口")
@RestController
@Slf4j
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    @ApiOperation(value = "",hidden = true)
    public UserDTO getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/add")
    @ApiOperation(value ="",hidden = true)
    public void createUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(UUID.randomUUID().toString());
        userDTO.setPassword("admin");
        userDTO.setCompanyId(UUID.randomUUID().toString());
        userDTO.setName("my name is");
        userDTO.setUserName("admin");
        userService.addUser(userDTO);
    }

    @PassToken
    @ApiOperation(value = "用户登录API")
    @PostMapping("/login")
    @SuppressWarnings({"unchecked"})
    public BaseResponse<JSONObject> login(@RequestBody LoginDTO loginDTO){
        log.info("进入Login");
        JSONObject jsonObject=new JSONObject();
        UserVO result = userService.login(loginDTO.getUserName(), loginDTO.getPassword());
        log.info("user result:"+result);
        if(result==null){
            return ResponseFactory.buildFailResponse(BaseResponseMsg.INVALIDED_USER.getMsg());
        }

        String token = TokenUtils.createJwtToken(loginDTO.getUserName());
        jsonObject.put("token", token);
        jsonObject.put("user", result);
        return ResponseFactory.buildSuccessResponse(jsonObject);
    }

    @UserLoginToken
    @ApiOperation(value = "",hidden = true)
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
