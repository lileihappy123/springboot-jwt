package com.springboot.jwt.auth.dao;

import com.springboot.jwt.auth.model.UserDTO;
import com.springboot.jwt.auth.model.UserVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author lilei
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 查询改邮箱是否被注册
     * @param userName 用户名
     * @return user对象
     */
    @Select("select * from base_user where user_name=#{userName}")
    UserDTO isExistUser(String userName);

    /**
     * 用户注册
     * @param userDTO 用户对象
     * @return 写入的数据量
     */
    @Insert("insert into base_user(id,password,company_id,name,user_name) values (#{id},#{password},#{companyId},#{name},#{userName})")
    @SelectKey(keyProperty = "id", resultType = String.class, before = true, statement = "select uuid() as id from dual")
    int addUser(UserDTO userDTO);

    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return 返回用户对象
     */
    @Result(property = "id",column = "id")
    @Result(property = "userName",column = "user_name")
    @Select("select user_name,name,id from base_user where user_name=#{userName} and password=#{password}")
    UserVO login(String userName, String password);

    /**
     * 通过ID查询用户信息，通过配置自动匹配camel命名
     * @param userId 用户id
     * @return 用户对象
     */
    @Select("select * from base_user where id=#{userId}")
    UserDTO queryInfoById(String userId);

    /**
     * 通过userName查询用户信息，通过配置自动匹配camel命名
     * @param userName 用户名
     * @return 用户对象
     */
    @Select("select * from base_user where user_name=#{userName}")
    UserDTO queryInfoByUserName(String userName);

    /**
     * get user by id， 通过mapper文件实现
     * @param id userId
     * @return user object
     */
    UserDTO getUserById(String id);
}