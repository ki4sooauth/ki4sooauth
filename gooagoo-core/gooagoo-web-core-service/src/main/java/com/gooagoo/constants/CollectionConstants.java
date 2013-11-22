package com.gooagoo.constants;

/**
 * Mongo集合常量，常量名称以库名做为前缀再加上集合名
 */
public class CollectionConstants
{
    /**用户购物集合**/
    public static final String ANLS_USER_SHOPPING_BASIC = "anls_user_shopping_basic";
    /** 帐户基本信息集合*/
    public static final String ANLS_ACCOUNT = "account";
    /**帐单集合*/
    public static final String ANLS_BILL = "bill";
    /**用户到店行为集合*/
    public static final String ANLS_ARRIVAL_SHOP = "arrival_shop";
    /**用户到区域集合*/
    public static final String ANLS_ARRIVAL_AREA = "arrival_area";
    /**收藏信息集合*/
    public static final String ANLS_FAVORITES = "favorites";
    /**评论集合*/
    public static final String ANLS_COMMENT = "comment";
    /**浏览集合*/
    public static final String ANLS_BROWSE = "browse";
    /**购买转化率统计集合*/
    public static final String ANLS_BUY_PERCENT = "anls_user_buy_percent_basic";
    /** 手机互动频次统计集合*/
    public static final String ANLS_PHONE_INTERACTION = "anls_user_phone_interaction";
    public static final String ANLS_USERSHOPPI = "user_shop_pi";
    public static final String ANLS_APPLYMEMBER = "apply_member";
    public static final String ANLS_APPLYPHYSICS = "apply_physics";
    public static final String ANLS_RECOMMEND = "anls_recommend";
    public final static String ANLS_TOOLS = "tools";
    public static final String ANLS_TYPE = "analysis_type";
    public static final String ANLS_USER_BY_FEATURE = "anls_user_feature";
    public static final String ANLS_USER_BY_BASIC = "anls_user_basic";
    public static final String ANLS_USER_GROUP = "anls_user_group";
    public static final String ANLS_USER_GROUP_DETAIL = "anls_user_group_detail";
    public static final String ANLS_QUERY_PARAMETERS = "query_parameters";
    public static final String ANLS_USER_BEHAVIOR = "anls_user_behavior";
    public static final String ANLS_UPDATE_LOG = "anls_update_log";

    /**足迹信息**/
    public static final String FM_FOOTMARK_NUM = "footmarkDB_num";
    public static final String FM_FOOTMARK_NUMS = "footmarkDB_nums";

    /**互动信息**/
    public static final String IA_INTERACTION_NUM = "interactionDB_num";
    public static final String IA_INTERACTION_NUMS = "interactionDB_nums";

    /**商家用户信息**/
    public static final String SU_SHOPUSER_NUM = "shopUserDB_num";
    public static final String SU_SHOPUSER_NUMS = "shopUserDB_nums";

    /**商家服务工具信息**/
    public static final String ST_SHOPTOOL_NUM = "shopToolDB_num";
    public static final String ST_SHOPTOOL_NUMS = "shopToolDB_nums";

    /**优惠凭证信息**/
    public static final String VC_VOUCHER_NUM = "voucherDB_num";
    public static final String VC_VOUCHER_NUMS = "voucherDB_nums";

    /**活动信息**/
    public static final String ACT_ACTIVITY_NUM = "activityDB_num";
    public static final String ACT_ACTIVITY_NUMS = "activityDB_nums";

    /**吆喝信息**/
    public static final String CO_CRYOUT_NUM = "cryoutDB_num";
    public static final String CO_CRYOUT_NUMS = "cryoutDB_nums";
    /**通知信息**/
    public static final String NT_NOTICE_NUM = "noticeDB_num";
    public static final String NT_NOTICE_NUMS = "noticeDB_nums";

    /**够好奇信息**/
    public static final String SP_SHOPPING_NUM = "shopingPryDB_num";
    public static final String SP_SHOPPING_NUMS = "shopingPryDB_nums";

    /**商品信息**/
    public static final String COM_COMMODITY_NUM = "commodityDB_num";
    public static final String COM_COMMODITY_NUMS = "commodityDB_nums";

    /**消费信息**/
    public static final String CS_CONSUMER_NUM = "consumerDB_num";
    public static final String CS_CONSUMER_CNUMS = "consumerDB_cnums";
    public static final String CS_CONSUMER_MNUMS = "consumerDB_mnums";

    /**业务数据缓存**/
    public final static String CACHE_DB_ACTIVITY = "cacheDB_activity";
    public final static String CACHE_DB_GOODS = "cacheDB_goods";
    public final static String CACHE_DB_COUPON = "cacheDB_coupon";

    /**日志信息*/
    public final static String logDB_BehaveLog = "logDB_BehaveLog";
    public final static String logDB_ShopLog = "logDB_ShopLog";
    public final static String logDB_SysLog = "logDB_SysLog";
    public final static String logDB_MessageLog = "logDB_MessageLog";
}
