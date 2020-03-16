package com.bruce.mailproducer.service;

import com.bruce.mailproducer.config.database.ReadOnlyConnection;
import com.bruce.mailproducer.entity.master.Dictionary;
import com.bruce.mailproducer.entity.master.DictionaryExample;
import com.bruce.mailproducer.mapper.master.DictionaryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: liujiande
 * @date: 2020/3/16 19:11
 * @description:
 */
@Service
public class DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @ReadOnlyConnection
    public List<Dictionary> getListByStatus(Integer status){

        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andStatusEqualTo(status);
        return dictionaryMapper.selectByExample(example);
    }
}
