package com.bruce.mailproducer;

import com.bruce.mailproducer.config.database.DataBaseContextHolder;
import com.bruce.mailproducer.config.database.ReadOnlyConnection;
import com.bruce.mailproducer.entity.master.Dictionary;
import com.bruce.mailproducer.entity.master.DictionaryExample;
import com.bruce.mailproducer.mapper.master.DictionaryMapper;
import com.bruce.mailproducer.service.DictionaryService;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MailProducerApplicationTests {

    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;

    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Resource
    private DictionaryService dictionaryService;

    @Test
    void contextLoads() throws Exception {
        Connection c1 = masterDataSource.getConnection("mailuser","123456");
        System.err.println("c1 -->{}" + c1.getMetaData().getURL());
        Connection c2 = slaveDataSource.getConnection("mailuser","123456");
        System.err.println("c2 -->{}" + c2.getMetaData().getURL());
    }

    @Test
    public void test1() throws Exception {
        PageHelper.startPage(1,2);
        List<Dictionary> dictionaries = dictionaryMapper.selectAll();
        for (Dictionary d: dictionaries) {
            System.err.println(d.getName());
        }
    }

    @Test
    public void test2() throws Exception {


        List<Dictionary> dictionaries = dictionaryService.getListByStatus(1);

        for (Dictionary d : dictionaries) {
            System.err.println(d.toString());
        }
    }

}
