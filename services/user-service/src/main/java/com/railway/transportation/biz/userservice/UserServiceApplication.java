package com.railway.transportation.biz.userservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户服务应用启动器
 */
@SpringBootApplication
@MapperScan("com.railway.transportation.biz.userservice.dao.mapper")
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
