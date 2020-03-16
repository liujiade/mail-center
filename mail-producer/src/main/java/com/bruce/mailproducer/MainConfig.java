package com.bruce.mailproducer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @auther: liujiande
 * @date: 2020/3/12 16:55
 * @description: 基础配置
 */
@EnableWebMvc //启用spring mvc
@Configuration //解释当前类为xml配置类 springboot启动时识别
@ComponentScan({"com.bruce.mailproducer.*"}) //扫描基础包
@MapperScan(basePackages = "com.bruce.mailproducer.mapper")
public class MainConfig {
}
