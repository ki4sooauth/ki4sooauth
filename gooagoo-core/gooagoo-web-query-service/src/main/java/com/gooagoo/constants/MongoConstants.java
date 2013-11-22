package com.gooagoo.constants;

import java.util.ResourceBundle;

/**
 * MongoDB信息常量类
 * @author zsl
 *
 */
public class MongoConstants
{
    private final static ResourceBundle bundle = ResourceBundle.getBundle("mongoDB");

    public final static String MONGO_URL = bundle.getString("mongo_url");
    public final static String MONGO_USER = bundle.getString("mongo_user");
    public final static String MONGO_PWD = bundle.getString("mongo_pwd");

    /**统计分析库**/
    public final static String analysisDB = bundle.getString("analysisDB");
    /**统计分析中间数据库**/
    public final static String analysisMiddleDB = bundle.getString("analysisMiddleDB");
    /**文件信息**/
    public final static String gridFSDB = bundle.getString("gridFSDB");
    /**足迹信息**/
    public final static String footmarkDB = bundle.getString("footmarkDB");
    /**互动信息**/
    public final static String interactionDB = bundle.getString("interactionDB");
    /**商家用户信息**/
    public final static String shopUserDB = bundle.getString("shopUserDB");
    /**商家服务工具信息**/
    public final static String shopToolDB = bundle.getString("shopToolDB");
    /**优惠凭证信息**/
    public final static String voucherDB = bundle.getString("voucherDB");
    /**活动信息**/
    public final static String activityDB = bundle.getString("activityDB");
    /**吆喝信息**/
    public final static String cryoutDB = bundle.getString("cryoutDB");
    /**通知信息**/
    public final static String noticeDB = bundle.getString("noticeDB");
    /**够好奇信息**/
    public final static String shopingPryDB = bundle.getString("shopingPryDB");
    /**商品信息**/
    public final static String commodityDB = bundle.getString("commodityDB");
    /**消费信息**/
    public final static String consumerDB = bundle.getString("consumerDB");
    /**业务数据缓存**/
    public final static String CACHE_DB = bundle.getString("cacheDB");
    /**日志信息*/
    public final static String logDB = bundle.getString("logDB");
    /**消息日志信息*/
    public final static String logDB_MessageLog = "logDB_MessageLog";
}
