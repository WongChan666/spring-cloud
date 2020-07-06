package com.meinergy.cloud.config;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Pattern;

/**
 * ZuulConfig
 *
 * @author chenwang
 * @date 2020/7/6
 */
@Configuration
public class ZuulConfig {
    //自定义serviceId和路由之间的相互映射
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        return new PatternServiceRouteMapper(
                "(?<project>^.+)-(?<subProject>.+$)",
                "${project}/${subProject}");
    }
}
