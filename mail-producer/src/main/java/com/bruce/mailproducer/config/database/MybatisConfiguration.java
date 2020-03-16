package com.bruce.mailproducer.config.database;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @auther: liujiande
 * @date: 2020/3/13 16:55
 * @description:
 */
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class}) //在DataSourceConfiguration加载完毕后加载当前bean
public class MybatisConfiguration extends MybatisAutoConfiguration {

    public MybatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }

    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;

    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    @Override
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        return super.sqlSessionFactory(roundRobinDataSourceProxy());
    }

    /**
     * @Author 刘建德
     * @Description 关联数据源
     * @date: 2020/3/13 5:15 PM
     */
    public AbstractRoutingDataSource roundRobinDataSourceProxy() {

        ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
        org.aspectj.apache.bcel.util.ClassLoaderRepository.SoftHashMap targetDataSource = new ClassLoaderRepository.SoftHashMap();
        targetDataSource.put(DataBaseContextHolder.DataBaseType.MASTER,masterDataSource);
        targetDataSource.put(DataBaseContextHolder.DataBaseType.SLAVE,slaveDataSource);

        //默认数据源
        proxy.setDefaultTargetDataSource(masterDataSource);
        //装入两个主从数据源
        proxy.setTargetDataSources(targetDataSource);
        return proxy;
    }
}
