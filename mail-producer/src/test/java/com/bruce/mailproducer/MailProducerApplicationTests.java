package com.bruce.mailproducer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class MailProducerApplicationTests {

    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;

    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    @Test
    void contextLoads() throws Exception {
        Connection c1 = masterDataSource.getConnection("mailuser","123456");
        System.err.println("c1 -->{}" + c1.getMetaData().getURL());
        Connection c2 = slaveDataSource.getConnection("mailuser","123456");
        System.err.println("c2 -->{}" + c2.getMetaData().getURL());
    }

}
