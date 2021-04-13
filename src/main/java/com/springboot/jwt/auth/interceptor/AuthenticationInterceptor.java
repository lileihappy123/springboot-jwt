package com.springboot.jwt.auth.interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.springboot.jwt.auth.model.UserDTO;
import com.springboot.jwt.common.model.BaseResponseMsg;
import com.springboot.jwt.auth.service.UserService;
import com.springboot.jwt.common.annotation.PassToken;
import com.springboot.jwt.common.annotation.UserLoginToken;
import com.springboot.jwt.common.exception.CustomException;
import com.springboot.jwt.common.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author lilei
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        log.info("interceptor in, token:"+token);
        log.info("info");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            log.info("直接return true了");
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        log.info("method : "+method);
        PassToken passToken = method.getAnnotation(PassToken.class);
        if (method.isAnnotationPresent(PassToken.class)&&passToken.required()) {
            log.info("pass token直接return true了");
            log.info("pass token 直接return true了");
            return true;
        }
        UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)&&userLoginToken.required()) {
            // 执行认证
            if (token == null) {
                throw new CustomException(BaseResponseMsg.INVALIDED_TOKEN.getMsg());
            }
            // 获取 token 中的 user id
            String userName;
            try {
                Claims claims = TokenUtils.parseJWT(token);
                String audience = claims.getAudience();
                String jti = claims.get("jti").toString();
                log.info("claims：",claims);
                log.info("audience：",audience);
                log.info("jti：",jti);
                userName = jti;
            } catch (JWTDecodeException j) {
                throw new CustomException(BaseResponseMsg.INVALIDED_TOKEN.getMsg());
            }
            UserDTO userDTO = userService.getUserByUserName(userName);
            if (userDTO == null) {
                throw new CustomException(BaseResponseMsg.INVALIDED_USER.getMsg());
            }

            return true;
        }
        log.info("最后了");
        return true;
    }
}