package com.gooagoo.common.gms.constants;

public class GMSConstant
{
    /**
     * 动线在SVG图中标识属性值在缓存中key
     */
    public final static String GENERATRIX_SVG_PROPERTY_KEY = "generatrix_svg_property";
    /**
     * 是否需要过滤特殊字符标志在request中的key
     */
    public final static String ESCAPE_STRING_TYPE_KEY = "ESCAPE_STRING_TYPE";
    /**
     * 商家需要过滤的消息行为类型在缓存中的Key
     */
    public final static String SHOP_LOG_FILTER_BEHAVE_TYPE_KEY = "shop_log_filter_behave_type";
    /**
     * 商家用户退出调用地址在缓存中的key
     */
    public final static String PASSPORT_SHOP_LOGOUT_KEY = "server_shop_logout_url";
    /**
     * 用户查询条件：用户行为所属类型-实时
     */
    public final static String USER_SEARCH_CONDITION_TYPE_REAL = "C";
    /**
     * 用户查询条件：用户行为所属类型-历史
     */
    public final static String USER_SEARCH_CONDITION_TYPE_HISTORY = "H";
    /**
     * request中接口类型参数名
     */
    public final static String INTERFACE_TYPE_REQUEST_KEY = "GMS.INTERFACE.TYPE";
    /**
     * 批跑的接口类型值（不发送消息日志）
     */
    public final static String INTERFACE_TYPE_BATCH = "BATCH";
    /**
     * 服务工具对应的根节点渠道编码
     */
    public final static String CHANNEL_TOOL_ROOT_CODE = "6";
    /**
     * 填写表单时的操作类型-添加
     */
    public final static String FORM_OPERATE_TYPE_ADD = "A";
    /**
     * 填写表单时的操作类型-添加
     */
    public final static String FORM_OPERATE_TYPE_UPDATE = "U";
    /**
     * 权限界面文字编码字典类型
     */
    public final static String INTERFACE_AUTH_NAME = "interface_auth_name";
    /**
     * 往Map中存放权限编码的key名称
     */
    public final static String MAP_KEY_AUTH_CODE = "MAP_KEY_AUTH_CODE";
    /**
     * 营销管理根节点权限编码
     */
    public final static String AUTH_CODE_MARKETING_ROOT = "1";
    /**
     * 位置顶级编码
     */
    public final static String POSITION_TOP_LEVEL = "-1";
    /**
     *静态文件访问的域名在缓存中的key值
     */
    public final static String HTML_URL_HEAD_KEY = "html_url_head";

    /**
     *商家类型-餐饮
     */
    public final static int SHOP_TYPE_FOOD = 1;
    /**
     *餐桌状态权限编码
     */
    public final static String AUTH_STATISTICS_TABLE = "1109";
    /**
     *商家桌号管理权限编码
     */
    public final static String AUTH_SHOP_TABLE = "1412";
    /**
     *规则类型-购好奇（事件）
     */
    public final static String ACTIVECONT_RULETYPE_GHQ = "0";
    /**
     *规则类型-吆喝
     */
    public final static String ACTIVECONT_RULETYPE_CRYOUT = "1";
    /**
     *规则类型-通知
     */
    public final static String ACTIVECONT_RULETYPE_NOTICE = "2";
    /**
     *规则类型-邮件（事件）
     */
    public final static String ACTIVECONT_RULETYPE_EMAIL = "3";
    /**
     *规则类型-短信
     */
    public final static String ACTIVECONT_RULETYPE_MESSAGE = "4";
    /**
     *规则类型-积分（规则结果）
     */
    public final static String ACTIVECONT_RULETYPE_JIFEN = "5";
    /**
     *规则类型-优惠（规则结果）
     */
    public final static String ACTIVECONT_RULETYPE_MONEY = "6";
    /**
     *规则类型-会员卡（规则结果）
     */
    public final static String ACTIVECONT_RULETYPE_CARD = "7";
    /**
     *规则类型-手机服务（事件）
     */
    public final static String ACTIVECONT_RULETYPE_MOBILE = "D";
    /**
     *规则类型-手机虚拟店铺（事件）
     */
    public final static String ACTIVECONT_RULETYPE_MVB = "E";
    /**
     *规则类型-网站虚拟店铺（事件）
     */
    public final static String ACTIVECONT_RULETYPE_WVB = "F";
    /**
     *规则类型-自定义工具（事件）
     */
    public final static String ACTIVECONT_RULETYPE_TOOL = "G";

    /**
     * 渠道中位置触发编码
     */
    public final static int CHANNEL_ROOT_CODE = -1;
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

    /**
     * crm中 标记条件为 年
     */
    public static final String YEAR = "Y";

    /**
     * crm中 标记条件为 月
     */
    public static final String MONTH = "M";

    /**
     * crm中 标记条件为 日
     */
    public static final String DAY = "D";

    /**
     * crm中 标记条件为 周
     */
    public static final String WEEK = "W";

    /**
     * crm中 标记条件为 时
     */
    public static final String HOUR = "H";

    /**
     * crm中  x轴的长度
     */
    public static final int xLength = 10;

    /**
     * crm中  商家平均数的map key
     */
    public static final String shopAverageKey = "shop_average_key";
    /**
     * crm中  实体店平均数的map key
     */
    public static final String entityAverageKey = "entity_average_key";

    /**
     * crm中 标记条件为 全部用户  1
     */
    public static final String ALL_USER = "1";

    /**
     * crm中 标记条件为 到访用户  2
     */
    public static final String TO_USER = "2";

    /**
     * crm中 标记条件为 新增用户  3
     */
    public static final String NEW_USER = "3";

    /**
     * crm中 标记条件为 全部会员  4
     */
    public static final String ALL_MEMBER = "4";

    /**
     * crm中 标记条件为 新增会员  5
     */
    public static final String NEW_MEMBER = "5";

    /**
     * crm中 标记条件为 到访会员  6
     */
    public static final String TO_MEMBER = "6";

    /**
     * crm中 标记条件为 活跃会员  7
     */
    public static final String ACTIVE_MEMBER = "7";

    /**
     * crm中 标记条件为 沉默会员  8
     */
    public static final String SILENT_MEMBER = "8";

    /**
     * crm中 标记条件为 流失会员  9
     */
    public static final String LOST_MEMBER = "9";

    /**
     * crm中 标记条件为 店内用户  10
     */
    public static final String STORE_USER = "10";

    /**
     * crm中 标记条件为 店内会员  11
     */
    public static final String STORE_MEMBER = "11";

    /**
     * crm中 标记条件为 手机互动会员  12
     */
    public static final String MOBIL_MEMBER = "12";

    /**
     * crm中 标记条件为 网店互动会员  13
     */
    public static final String WEB_MEMBER = "13";

    /**
     * 账号类型  用户id
     */
    public static final String ACCOUNTTYPE_USERID = "0";
    /**
     * 账号类型  mac地址
     */
    public static final String ACCOUNTTYPE_MAC = "3";
    /**
     * 账号类型  物理卡号
     */
    public static final String ACCOUNTTYPE_PHY_CARD_NO = "7";

}
