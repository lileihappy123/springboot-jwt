package com.springboot.jwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author lilei
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@MapperScan("com.springboot.jwt.auth.dao")
public class SpringBootJWTApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJWTApplication.class, args);
    }

}
