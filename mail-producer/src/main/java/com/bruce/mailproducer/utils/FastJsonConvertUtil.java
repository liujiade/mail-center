package com.bruce.mailproducer.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: liujiande
 * @date: 2020/3/13 11:39
 * @description:
 */
public class FastJsonConvertUtil {

    private static final SerializerFeature[] featuresWithNullValue = {SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullBooleanAsFalse};

    /**
     * @Author 刘建德
     * @Description JSON格式字符串转实体对象
     * @date: 2020/3/13 11:51 AM
     */
    public static <T> T convertJSONToObject(String data, Class<T> clazz) {
        try {
            T t = JSON.parseObject(data,clazz);
            return t;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author 刘建德
     * @Description JSON对象转实体对象
     * @date: 2020/3/13 11:53 AM
     */
    public static <T> T convertJSONToObject(JSONObject data, Class<T> clazz) {
        try{
            T t = JSONObject.toJavaObject(data, clazz);
            return t;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author 刘建德
     * @Description 将JSON字符串数组转List对象集合
     * @date: 2020/3/13 11:56 AM
     */
    public static <T> List<T> convertJSONToArray(String data, Class<T> clazz) {
        try {
            List<T> t = JSON.parseArray(data,clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author 刘建德
     * @Description 将List<JSONObject>转集合对象
     * @date: 2020/3/13 12:01 PM
     */
    public static <T> List<T> convertJSONToArray(List<JSONObject> data, Class<T> clazz) {
        try {
            List<T> t = new ArrayList<T>();
            for (JSONObject jsonObject : data) {
                t.add(convertJSONToObject(jsonObject,clazz));
            }
            return t;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author 刘建德
     * @Description 将对象转JSON字符串
     * @date: 2020/3/13 2:02 PM
     */
    public static String convertObjectToJSON(Object obj){
        try {
            String text = JSON.toJSONString(obj);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author 刘建德
     * @Description 实体对象转JSON对象
     * @date: 2020/3/13 2:04 PM
     */
    public static JSONObject convertObjectToJSONObject(Object obj){
        try {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author 刘建德
     * @Description 实体对象转json排除空
     * @date: 2020/3/13 2:08 PM
     */
    public static String convertObjectToJSONWithNullValue(Object obj) {
        try {
            String text = JSON.toJSONString(obj, featuresWithNullValue);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
