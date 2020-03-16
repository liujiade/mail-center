package com.bruce.mailproducer.config.database;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @auther: liujiande
 * @date: 2020/3/16 15:54
 * @description: 基础数据库服务
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
