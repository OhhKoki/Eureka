package com.example.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RibbonConfig {

    /**
     * 往 IOC 注入一个 IRule 的实现类，Ribbon 将采用该实现类进行负载均衡操作
     */
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }

}
