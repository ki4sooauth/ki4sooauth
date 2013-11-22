package com.gooagoo.mis.constants;
/**
 * Redis-地址配置常量
 * @author Administrator
 *
 */
public class RedisServerConstantsMis
{
    /**
     * 记录用户最后一次停留区域信息
     * redis.statistics.goo.com:6379 0
     */
    public static final String statistics_lastarea = "statistics_lastarea";
    /**
     * 区域用户信息
     * redis.statistics.goo.com:6379 2
     */
    public static final String statistics_areaUserInf = "statistics_areaUserInf";

    /**
     * 区域会员信息
     * redis.statistics.goo.com:6379 4
     */
    public static final String statistics_areaMember = "statistics_areaMember";
    /**
     * 商家当天新增会员信息
     * redis.statistics.goo.com:6379 6
     */
    public static final String statistics_newMemberInf = "statistics_newMemberInf";
    /**
     * 店内潜在会员信息
     * redis.statistics.goo.com:6379 8
     */
    public static final String statistics_potentialInfo = "statistics_potentialInfo";
    /**
     * 按餐桌类型统计实体店已点餐未结账的餐桌
     * redis.statistics.goo.com:6379 9
     */
    public static final String statistics_notCheckout = "statistics_notCheckout";

    /**
     * 按餐桌类型统计实体店正在结账的餐桌
     * redis.statistics.goo.com:6379 10
     */
    public static final String statistics_beingCheckout = "statistics_beingCheckout";
    /**
     * 按餐桌号统计实体店餐桌状态
     * redis.statistics.goo.com:6379 11
     */
    public static final String statistics_tablestatus = "statistics_tablestatus";
    /**
     * 按商品统计实体店当天的销售数量
     * redis.statistics.goo.com:6379 12
     */
    public static final String statistics_daySales = "statistics_daySales";
    /**
     * 按商品统计实体店当周的销售数量
     * redis.statistics.goo.com:6379 13
     */
    public static final String statistics_weekSales = "statistics_weekSales";
    /**
     * 统计信息关联用户
     * redis.statistics.goo.com:6379 14
     */
    public static final String statistics_relevantUser = "statistics_relevantUser";
    /**
     * 手机互动会员信息
     * 手机潜在会员信息
     * 网店互动会员信息
     * 网店潜在会员信息
     * redis.statistics.goo.com:6379 15
     */
    public static final String statistics_realTime = "statistics_realTime";
    /**
     * 个人登录信息（GUS）
     * redis.login.goo.com:6379 0
     */
    public static final String login_gus = "login_gus";
    /**
     * 手机登录信息（MOBILE）
     * redis.login.goo.com:6379 1
     */
    public static final String login_mobile = "login_mobile";
    /**
     * 商家登录信息（GMS和CRM）
     * redis.login.goo.com:6379 2
     */
    public static final String login_gms = "login_gms";
    /**
     * 转发器长连接信息
     * redis.login.goo.com:6379 3
     */
    public static final String login_repeater = "login_repeater";
    /**
     * 店员助理长连接信息
     * redis.login.goo.com:6379 4
     */
    public static final String login_assistant = "login_assistant";
    /**
     * 语音长连接信息
     * redis.login.goo.com:6379 5
     */
    public static final String login_voiceSocket = "login_voiceSocket";
    /**
     * 手机长连接信息
     * redis.login.goo.com:6379 6
     */
    public static final String login_mobileSocket = "login_mobileSocket";
    /**
     * 验证码信息
     * redis.login.goo.com:6379 7
     */
    public static final String login_verification = "login_verification";
    /**
     * 后台登录信息
     * redis.login.goo.com:6379 8
     */
    public static final String login_mis = "login_mis";
}
