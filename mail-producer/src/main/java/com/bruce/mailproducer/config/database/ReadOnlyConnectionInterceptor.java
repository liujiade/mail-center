package com.bruce.mailproducer.config.database;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @auther: liujiande
 * @date: 2020/3/16 11:06
 * @description: 读写分离拦截器
 */
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {

    public static final Logger logger = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
        try{
            logger.info("------------set database connection to read only------------");

            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            //清空只读
            DataBaseContextHolder.clearDataBaseType();
            logger.info("------------clear database connection------------");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
