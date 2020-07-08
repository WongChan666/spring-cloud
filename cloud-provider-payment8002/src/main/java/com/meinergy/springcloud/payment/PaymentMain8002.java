package com.meinergy.springcloud.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：Wong
 * @date ：Created in 2020/7/4 11:40
 * @description：支付模块主程序入口
 * @modified By：
 * @version:
 */
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@MapperScan("com.meinergy.springcloud.payment.mapper")
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }


    //请求发送信息中特殊字符适应
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "|{}[]\\"));
        return factory;
    }
}
