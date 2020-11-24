package com.yc.picLib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient    //启用eureka客户端

@EnableDiscoveryClient
//@RibbonClient(name = "MICROSERVICE-PROVIDER", configuration = RibbonConfig.class)
//启用feign客户端
@EnableFeignClients("com.yc.picLib.service")  //注意:这里的值要填服务接口所在的包名
public class ConsumerApp01 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp01.class, args);
    }


}