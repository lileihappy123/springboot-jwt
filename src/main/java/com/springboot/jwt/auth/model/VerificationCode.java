package com.springboot.jwt.auth.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 验证码类
 * @author lilei
 */
@Entity
@Data
@Table(name = "verification_code")
public class VerificationCode {
    @Id
    @Column(name = "register_id")
    private String registerId;
    @Column(name = "email")
    private String email;
    @Column(name = "code")
    private String code;
    @Column(name = "time")
    private Date time;

}