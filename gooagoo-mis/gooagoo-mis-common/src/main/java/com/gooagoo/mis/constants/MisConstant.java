package com.gooagoo.mis.constants;
/**
 * 后台管理系统地址配置常量
 * @author Administrator
 *
 */
public class MisConstant
{
    /**
     * 渠道中位置触发编码
     */
    public final static int CHANNEL_ROOT_CODE = 0;
    /**
     * 渠道中位置触发编码
     */
    public final static int CHANNEL_POSITION_CODE = 3;
    /**
     * 一级渠道列表
     */
    public final static String CHANNEL_ROOT_LIST = "com.gooagoo.marketing.channelRootList";
    /**
     * 渠道树形列表
     */
    public final static String ZTREE_CHANNEL_LIST = "com.gooagoo.marketing.ztreeChannelList";
    /**
     * 位置树形列表
     */
    public final static String ZTREE_POSITION_LIST = "com.gooagoo.marketing.ztreePositionList";

    /**
     * 是
     */
    public final static String YES = "Y";
    /**
     * 否
     */
    public final static String NO = "N";
    /**
     * 男
     */
    public final static String SEX_MALE = "M";
    /**
     * 女
     */
    public final static String SEX_FEMALE = "F";
    /**
     * 身份证
     */
    public final static String IDTYPE_ID = "00";
    /**
     * 护照
     */
    public final static String IDTYPE_PASSPORT = "01";
    /**
     * 军官证
     */
    public final static String IDTYPE_ARMY = "02";
    /**
     * 其它
     */
    public final static String IDTYPE_OTHER = "03";
    /**
     * 申请状态-通过
     */
    public final static String APPLY_STATUS_SUCCESS = "P";
    /**
     * 申请状态-不通过
     */
    public final static String APPLY_STATUS_FAIL = "N";
    /**
     * 申请状态-未处理
     */
    public final static String APPLY_STATUS_WAIT = "W";
    /**
     * 信息来源-网站端
     */
    public final static String INFO_SOURCE_WEB = "W";
    /**
     * 信息来源-手机端
     */
    public final static String INFO_SOURCE_MOBILE = "M";
    /**
     * 规则类型-积分规则
     */
    public final static String RULE_TYPE_INTEGER = "I";
    /**
     * 规则类型-营销规则
     */
    public final static String RULE_TYPE_MARKETING = "M";
    /**
     * 营销内容关联类型-商品
     */
    public final static String MARKETING_LINK_TYPE_GOOD = "G";
    /**
     * 营销内容关联类型-活动
     */
    public final static String MARKETING_LINK_TYPE_ACTIVITY = "A";
    /**
     * 营销内容关联类型-优惠凭证
     */
    public final static String MARKETING_LINK_TYPE_COUPON = "C";
    /**
     * 吆喝类型-现场
     */
    public final static String CRYOUT_TYPE_LOCAL = "L";
    /**
     * 吆喝类型-远程
     */
    public final static String CRYOUT_TYPE_REMOTE = "R";
    /**
     * 服务工具类型-现场
     */
    public final static String TOOL_TYPE_LOCAL = "L";
    /**
     * 服务工具类型-远程
     */
    public final static String TOOL_TYPE_REMOTE = "R";
    /**
     * 通知类型-商家通知
     */
    public final static String NOTICE_TYPE_SHOP = "S";
    /**
     * 通知类型-管理员通知
     */
    public final static String NOTICE_TYPE_MANAGER = "M";
    /**
     * 优惠凭证类型-代金券
     */
    public final static String COUPON_TYPE_CASH = "C";
    /**
     * 优惠凭证类型-代金券
     */
    public final static String COUPON_TYPE_DISCOUNT = "D";
    /**
     * 优惠凭证来源类型-商家创建
     */
    public final static String COUPON_SOURCE_TYPE_SHOP = "S";
    /**
     * 优惠凭证来源类型-系统自动创建
     */
    public final static String COUPON_SOURCE_TYPE_SYSTEM = "A";
    /**
     * 商家状态-锁定
     */
    public final static String SHOP_STATUS_TYPE_LOCK = "L";
    /**
     * 商家状态-待营业
     */
    public final static String SHOP_STATUS_TYPE_PREPARE = "P";
    /**
     * 商家状态-正常营业
     */
    public final static String SHOP_STATUS_TYPE_NORMAL = "N";
    /**
     * 应用部署模式-平台代理
     */
    public final static String SHOP_SERVICE_TYPE_PLATFORM = "A";
    /**
     * 应用部署模式-商家独立
     */
    public final static String SHOP_SERVICE_TYPE_SHOP = "S";
    /**
     * 营销类型-事件营销
     */
    public final static String MARKETING_TYPE_EVENT = "E";
    /**
     * 营销类型-事件营销
     */
    public final static String MARKETING_TYPE_CRYOUT = "C";
    /**
     * 营销类型-事件营销
     */
    public final static String MARKETING_TYPE_NOTICE = "N";
    /**
     * 营销类型-事件营销
     */
    public final static String MARKETING_TYPE_MAIL = "M";
    /**
     * 营销激励类型-激励
     */
    public final static String MARKETING_SALE_TYPE_AWARD = "0";
    /**
     * 营销激励类型-交叉
     */
    public final static String MARKETING_SALE_TYPE_CROSS = "1";
    /**
     * 营销激励类型-追加
     */
    public final static String MARKETING_SALE_TYPE_ADD = "2";
    /**
     * 审核发布状态-待审核
     */
    public final static String AUDIT_STATUS_TYPE_PREPARE = "W";
    /**
     * 审核发布状态-通过审核
     */
    public final static String AUDIT_STATUS_TYPE_SUCCESS = "A";
    /**
     * 审核发布状态-不通过审核
     */
    public final static String AUDIT_STATUS_TYPE_FAIL = "B";
    /**
     * 审核发布状态-已发布
     */
    public final static String AUDIT_STATUS_TYPE_RELEASE = "P";

    /**
     * 用户Id
     */
    public static final String USERID = "gms.userId";
    /**
     * 实体店id
     */
    public static final String ENTITYID = "gms.entityId";
    /**
     * 商家id
     */
    public static final String SHOPID = "gms.shopId";

    /**
     * （登录类型）商家
     */
    public static final String SHOPTYPE = "S";

    /**
     * （登录类型）商家用户
     */
    public static final String USERTYPE = "A";
}
