package com.yc.picLib.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    //加入安全配置
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","b");
    }


}
