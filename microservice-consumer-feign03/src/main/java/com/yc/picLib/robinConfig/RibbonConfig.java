package com.yc.picLib.robinConfig;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
//放到另一个报，不被spring托管
public class RibbonConfig {
    @Bean
    public IRule ribbonRule(){//  其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule();//随机访问的策略
    }
}
