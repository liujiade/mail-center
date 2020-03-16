package com.bruce.mailproducer.constant;

/**
 * @auther: liujiande
 * @date: 2020/3/12 17:10
 * @description:
 */
public final class Const {

    private Const() {
    }

    /** 环境 - 本地 */
    public static final String SPRING_PROFILE_DEV = "dev";

    /** 环境 - 生产 */
    public static final String SPRING_PROFILE_PROD = "prod";

    /** 环境 - 测试 */
    public static final String SPRING_PROFILE_STAGING = "staging";

    /** 判断：是 */
    public static final String TRUE = "1";

    /** 判断：否 */
    public static final String FALSE = "0";

    /** 通用字符集编码 UTF-8 */
    public static final String CHARSET_UTF8 = "UTF-8";

    /** 中文字符集编码 GBK */
    public static final String CHARSET_CHINESE = "GBK";

    /** 英文字符集编码 ISO-8859-1 */
    public static final String CHARSET_ENGLISH = "ISO-8859-1";

    /** 根结点id root */
    public static final String ROOT_ID = "root";

    /** NULL 字符串 */
    public static final String NULL = "null";

    /** 本机地址名 localhost */
    public static final String LOCALHOST = "localhost";

    /** 日期格式 yyyy-MM-dd */
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    /** 日期格式 yyyyMMdd */
    public static final String FORMAT_DATE_SHORT = "yyyyMMdd";

    /** 日期格式 yyyy-MM-dd HH:mm:ss */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /** 日期格式 yyyyMMddHHmmss */
    public static final String FORMAT_DATETIME_SHORT = "yyyyMMddHHmmss";

    /** 日期格式 yyyy-MM-dd HH:mm:ss.SSS */
    public static final String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";

    /** 日期格式 yyyyMMddHHmmss */
    public static final String FORMAT_TIMESTAMP_SHORT = "yyyyMMddHHmmssSSS";

    /** 成功 */
    public static final String SUCCESS = "success";

    /** 失败 */
    public static final String FAILURE = "failure";

    /** 下划线分割 */
    public static final String UNDERLINE_SPLIT = "_";

    /** 逗号分割 */
    public static final String COMMA_SPLIT = ",";

    /** 操作人：系统（运行时） */
    public static final String SYS_RUNTIME = "SYS_RUNTIME";

    /** 操作人：系统（初始化） */
    public static final String SYS_INIT = "SYSINT";
}
