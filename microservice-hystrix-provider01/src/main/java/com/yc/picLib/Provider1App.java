package com.yc.picLib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@EnableDiscoveryClient  //启动服务器发现客户端，以获取当前provider的注册信息
public class Provider1App {

    public static void main(String[] args) {

        SpringApplication.run(Provider1App.class, args);
    }

}
