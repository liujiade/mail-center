package com.bruce.mailproducer.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

/**
 * @auther: liujiande
 * @date: 2020/3/13 11:32
 * @description: 生成主键所用
 */
public class KeyUtil {

    /**
     * @Author 刘建德
     * @Description 主键生成策略
     * @date: 2020/3/13 11:34 AM
     */
    public static String generatorUUID(){
        TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        return timeBasedGenerator.generate().toString();
    }


    public static void main(String[] args) {
        System.out.println(KeyUtil.generatorUUID());
        System.out.println(KeyUtil.generatorUUID());
        System.out.println(KeyUtil.generatorUUID());
    }
}
