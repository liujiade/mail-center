package com.bruce.mailproducer.config.database;

/**
 * @auther: liujiande
 * @date: 2020/3/13 16:46
 * @description: 数据源读写分离
 */
public class DataBaseContextHolder {

    public enum DataBaseType {
        MASTER,SLAVE
    }

    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<DataBaseType>();

    /**
     * @Author 刘建德
     * @Description 选择主从数据源
     * @date: 2020/3/13 4:53 PM
     */
    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (null == dataBaseType) {
            throw new NullPointerException();
        }
        contextHolder.set(dataBaseType);
    }

    /**
     * @Author 刘建德
     * @Description 获取当前数据源
     * @date: 2020/3/13 4:53 PM
     */
    public static DataBaseType getDataBaseType() {
        return contextHolder.get() == null ? DataBaseType.MASTER : contextHolder.get();
    }

    /**
     * @Author 刘建德
     * @Description 清空当前所用数据源
     * @date: 2020/3/13 4:54 PM
     */
    public static void clearDataBaseType(){
        contextHolder.remove();
    }
}
