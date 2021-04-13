# springboot-jwt

Spring Boot 实现基于JWT的认证方式

使用方式：
1. 找到application.yml文件，修改下面的配置
    url: jdbc:mysql://{mysql-server-ip}:3306/{dbname}?useUnicode=true&characterEncoding=UTF8
    username: {userName}
    password: {password}

2. 把{mysql-server-ip},{dbname},{userName},{password}替换为实际可访问的数据库连接信息
3. 运行/resources/sql/base_user.sql中的sql语句，创建用户表
4. 运行test/UserDTOMapperTest.java/addUser，添加测试用户
5. 用户postMane调用/login接口，查看效果
