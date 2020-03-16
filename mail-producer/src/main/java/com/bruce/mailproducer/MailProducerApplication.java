package com.bruce.mailproducer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author 刘建德
 * @Description producer主入口
 * @date: 2020/3/12 4:55 PM
 */
@SpringBootApplication
@EnableWebMvc //启用spring mvc
@ComponentScan({"com.bruce.mailproducer.*"}) //扫描基础包
@MapperScan(basePackages = "com.bruce.mailproducer.mapper")
public class MailProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailProducerApplication.class, args);
    }

}
