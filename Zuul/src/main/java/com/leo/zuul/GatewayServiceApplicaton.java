package com.leo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy //开启Zuul的功能
@EnableEurekaClient//向Eureka Server进行配置。
@SpringBootApplication
public class GatewayServiceApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplicaton.class,args);
    }
}