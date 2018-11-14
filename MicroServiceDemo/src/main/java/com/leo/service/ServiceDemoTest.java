package com.leo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//添加6：增加@EurekaClient，开启eureka服务
@EnableEurekaClient
@SpringBootApplication
//...包扫描、Swagger、事务等其他配置省略
public class ServiceDemoTest {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDemoTest.class, args);
    }

}