package com.googoo.batch.constants;

import java.util.ResourceBundle;

public class BatchConsants
{
    /**
     * 生成文件每次取多少条数据
     */
    //public static final int DAYS = Integer.parseInt(ResourceBundle.getBundle("fileConfig").getObject("days").toString());
    /**
     * 用户状态历史状态获取数据条数
     */
    public static final int USER_RECORD_COUNT = Integer.parseInt(ResourceBundle.getBundle("batch").getObject("userRecordCount").toString());

    /*
     * 
     */
    public static final String ACTIVITY = (String) ResourceBundle.getBundle("batch").getObject("activity");
    public static final String NOTICE = (String) ResourceBundle.getBundle("batch").getObject("notice");
    public static final String CRYOUT = (String) ResourceBundle.getBundle("batch").getObject("cryout");
    public static final String INQUISITIVE = (String) ResourceBundle.getBundle("batch").getObject("inquisitive");
    public static final String PHONETOOL = (String) ResourceBundle.getBundle("batch").getObject("phonetool");

    public static final String BRAND = (String) ResourceBundle.getBundle("batch").getObject("brand");
    public static final String CATEGORY = (String) ResourceBundle.getBundle("batch").getObject("category");
    public static final String COUPON = (String) ResourceBundle.getBundle("batch").getObject("coupon");
    public static final String GOODS = (String) ResourceBundle.getBundle("batch").getObject("goods");
    public static final String TOOLS = (String) ResourceBundle.getBundle("batch").getObject("tools");
    public static final String USER_RECORD = (String) ResourceBundle.getBundle("batch").getObject("userRecord");
}
