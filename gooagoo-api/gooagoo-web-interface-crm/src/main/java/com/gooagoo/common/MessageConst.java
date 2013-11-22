package com.gooagoo.common;

public final class MessageConst
{
    /**
     *手机接口提示信息（mobile）--START
     */

    /**
     *用户编号不能为空
     */
    public final static String MOBILE_PARAMETER_USERID_IS_NULL = "MOBA01";

    /**
     *sessionid值不能为空
     */
    public final static String MOBILE_PARAMETER_SESSIONID_IS_NULL = "MOBA02";

    /**
     *用户输入的关键字不能为空
     */
    public final static String MOBILE_PARAMETER_KEYWORD_IS_NULL = "MOBA03";

    /**
     *手机号不能为空
     */
    public final static String MOBILE_PARAMETER_PHONE_IS_NULL = "MOBA04";

    /**
     *最大时间戳不能为空
     */
    public final static String MOBILE_PARAMETER_CTIMESTAMP_IS_NULL = "MOBA05";

    /**
     *商品信息不能为空
     */
    public final static String MOBILE_PARAMETER_GOODSINFO_IS_NULL = "MOBA06";

    /**
     *商品编号不能为空
     */
    public final static String MOBILE_PARAMETER_GOODSID_IS_NULL = "MOBA07";

    /**
     *每页的条数不能为空
     */
    public final static String MOBILE_PARAMETER_PAGESIZE_IS_NULL = "MOBA08";

    /**
     *当前要加载的页码不能为空
     */
    public final static String MOBILE_PARAMETER_PAGENUM_IS_NULL = "MOBA09";

    /**
     *查询类型不能为空
     */
    public final static String MOBILE_PARAMETER_TYPE_IS_NULL = "MOBA10";

    /**
     *商家编号与实体店编号二选一必填不能为空
     */
    public final static String MOBILE_PARAMETER_SHOPID_AND_SHOPENTITYID_IS_NULL = "MOBA11";

    /**
     *是否查询推荐吆喝标识不能为空
     */
    public final static String MOBILE_PARAMETER_RECOMMENDTYPE_IS_NULL = "MOBA12";

    /**
     *当“翻页类型”为“下一页”时吆喝编号不能为空
     */
    public final static String MOBILE_PARAMETER_PAGETYPE_IS_N_CRYOUTINFOID_IS_NULL = "MOBA13";

    /**
     *订单编号不能为空
     */
    public final static String MOBILE_PARAMETER_ORDERID_IS_NULL = "MOBA14";

    /**
     *手机mac地址不能为空
     */
    public final static String MOBILE_PARAMETER_MAC_IS_NULL = "MOBA15";

    /**
     *订单类型不能为空
     */
    public final static String MOBILE_PARAMETER_ORDERTYPE_IS_NULL = "MOBA16";

    /**
     *桌号、房间不能为空
     */
    public final static String MOBILE_PARAMETER_CODE2D_IS_NULL = "MOBA17";

    /**
     *实体店编号不能为空
     */
    public final static String MOBILE_PARAMETER_SHOPENTITYID_IS_NULL = "MOBA18";

    /**
     *一维码或二维码不能为空
     */
    public final static String MOBILE_PARAMETER_CODEVALUE_IS_NULL = "MOBA19";

    /**
     *页码不能为空
     */
    public final static String MOBILE_PARAMETER_PAGEINDEX_IS_NULL = "MOBA20";

    /**
     *桌号不能为空
     */
    public final static String MOBILE_PARAMETER_DESKNO_IS_NULL = "MOBA21";

    /**
     *当同步方式为根据lid获得同步信息时LID不能为空
     */
    public final static String MOBILE_PARAMETER_GET_SHOPINFO_LID_IS_NULL = "MOBA22";

    /**
     *请求基本信息类型不能为空
     */
    public final static String MOBILE_PARAMETER_REQUESTTYPE_IS_NULL = "MOBA23";

    /**
     *当请求信息类型为购物计划商品分类时店铺信息不能为空
     */
    public final static String MOBILE_PARAMETER_SHOPINFO_IS_NULL = "MOBA24";

    /**
     *lid不能为空
     */
    public final static String MOBILE_PARAMETER_LID_IS_NULL = "MOBA25";

    /**
     *地图编号不能为空
     */
    public final static String MOBILE_PARAMETER_MAPID_IS_NULL = "MOBA26";

    /**
     *起点map编号不能为空
     */
    public final static String MOBILE_PARAMETER_SMAPID_IS_NULL = "MOBA27";

    /**
     *起点x坐标不能为空
     */
    public final static String MOBILE_PARAMETER_SPX_IS_NULL = "MOBA28";

    /**
     *起点y坐标不能为空
     */
    public final static String MOBILE_PARAMETER_SPY_IS_NULL = "MOBA29";

    /**
     *终点map编号不能为空
     */
    public final static String MOBILE_PARAMETER_EMAPID_IS_NULL = "MOBA30";

    /**
     *终点x坐标不能为空
     */
    public final static String MOBILE_PARAMETER_EPX_IS_NULL = "MOBA31";

    /**
     *终点y坐标不能为空
     */
    public final static String MOBILE_PARAMETER_EPY_IS_NULL = "MOBA32";

    /**
     *实体店编号或商品编号不能为空
     */
    public final static String MOBILE_PARAMETER_OBJID_IS_NULL = "MOBA33";

    /**
     *类型不能为空
     */
    public final static String MOBILE_PARAMETER_SEARCH_IS_NULL = "MOBA34";

    /**
     *用户使用手机行为不能为空
     */
    public final static String MOBILE_PARAMETER_BEHAVIOR_IS_NULL = "MOBA35";

    /**
     *通知编号不能为空
     */
    public final static String MOBILE_PARAMETER_NOTICEID_IS_NULL = "MOBA36";

    /**
     *收藏编号不能为空
     */
    public final static String MOBILE_PARAMETER_FAVORIATEID_IS_NULL = "MOBA37";

    /**
     *翻页类型不能为空
     */
    public final static String MOBILE_PARAMETER_PAGETYPE_IS_NULL = "MOBA38";

    /**
     *分页编号不能为空
     */
    public final static String MOBILE_PARAMETER_PAGEID_IS_NULL = "MOBA39";

    /**
     *分页类型不正确
     */
    public final static String MOBILE_PARAMETER_PAGETYPE_ERROR = "MOBA40";

    /**
     *查询成功
     */
    public final static String MOBILE_COMMON_QUERY_SUCCESS = "MOBB01";

    /**
     *查询失败
     */
    public final static String MOBILE_COMMON_QUERY_FAIL = "MOBB02";

    /**
     *未查询到符合条件的数据
     */
    public final static String MOBILE_COMMON_NOT_GET_WANT_DATA = "MOBB03";

    /**
     *删除成功
     */
    public final static String MOBILE_COMMON_DEL_DATA_SUCCESS = "MOBB04";

    /**
     *删除失败
     */
    public final static String MOBILE_COMMON_DEL_DATA_FAIL = "MOBB05";

    /**
     *提交成功
     */
    public final static String MOBILE_COMMON_SUBMIT_DATA_SUCCESS = "MOBB06";

    /**
     *提交失败
     */
    public final static String MOBILE_COMMON_SUBMIT_DATA_FAIL = "MOBB07";

    /**
     *系统异常
     */
    public final static String MOBILE_COMMON_SYSTEM_EXCEPTION = "MOBB08";

    /**
     *店铺编号不能为空
     */
    public final static String MOBILE_PARAMETER_SHOPID_IS_NULL = "MOBC01";

    /**
     *用户姓名不能为空
     */
    public final static String MOBILE_PARAMETER_USERNAME_IS_NULL = "MOBC02";

    /**
     *真实姓名不能为空
     */
    public final static String MOBILE_PARAMETER_REALNAME_IS_NULL = "MOBC03";

    /**
     *手机号、身份证号二选一必填
     */
    public final static String MOBILE_PARAMETER_PHONE_AND_IDNO_IS_NULL = "MOBC04";

    /**
     *身份证号不能为空
     */
    public final static String MOBILE_PARAMETER_IDNO_IS_NULL = "MOBC05";

    /**
     *实体卡号不能为空
     */
    public final static String MOBILE_PARAMETER_PHYNO_IS_NULL = "MOBC06";

    /**
     *卡号不能为空
     */
    public final static String MOBILE_PARAMETER_CARDID_IS_NULL = "MOBC07";

    /**
     *用户会员卡音频编号不能为空
     */
    public final static String MOBILE_PARAMETER_SCARDNO_IS_NULL = "MOBC08";

    /**
     *卡类型不能为空
     */
    public final static String MOBILE_PARAMETER_CARDTYPE_IS_NULL = "MOBC09";

    /**
     *是否同意不能为空
     */
    public final static String MOBILE_PARAMETER_IAGREE_IS_NULL = "MOBC10";

    /**
     *最大时间戳及入参（会员卡号、每页信息显示条数）两者不能都为空
     */
    public final static String MOBILE_PARAMETER_CTIMESTAMP_SCARDNO_PAGESIZE_IS_NULL = "MOBC45";

    /**
     *通知与用户关联的编号不能为空
     */
    public final static String MOBILE_PARAMETER_NOTICEUSERID_IS_NULL = "MOBC46";

    /**
     *删除会员卡成功
     */
    public final static String MOBILE_CARDTOP_DEL_MEMBERCARD_SUCCESS = "MOBC11";

    /**
     *删除会员卡失败
     */
    public final static String MOBILE_CARDTOP_DEL_MEMBERCARD_FAIL = "MOBC12";

    /**
     *会员卡已删除
     */
    public final static String MOBILE_CARDTOP_ALREADY_DEL_MEMBERCARD = "MOBC13";

    /**
     *删除账单成功
     */
    public final static String MOBILE_CARDTOP_DEL_BILL_SUCCESS = "MOBC14";

    /**
     *删除账单失败
     */
    public final static String MOBILE_CARDTOP_DEL_BILL_FAIL = "MOBC15";

    /**
     *账单已删除
     */
    public final static String MOBILE_CARDTOP_ALREADY_DEL_BILL = "MOBC16";

    /**
     *删除通知成功
     */
    public final static String MOBILE_CARDTOP_DEL_RECEIVE_NOTICE_SUCCESS = "MOBC17";

    /**
     *删除通知失败
     */
    public final static String MOBILE_CARDTOP_DEL_RECEIVE_NOTICE_FAIL = "MOBC18";

    /**
     *通知已删除
     */
    public final static String MOBILE_CARDTOP_ALREADY_DEL_RECEIVE_NOTICE = "MOBC19";

    /**
     *申请电子会员卡成功,请等待审核
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_SUCCESS = "MOBC20";

    /**
     *申请电子会员卡失败
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_FAIL = "MOBC21";

    /**
     *姓名格式不正确，长度不能超过32个字符
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_NAME_FORMATTER_ERROR = "MOBC22";

    /**
     *性别信息不正确
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_SEX_FORMATTER_ERROR = "MOBC23";

    /**
     *该证件类型不存在
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_IDTYPE_FORMATTER_ERROR = "MOBC24";

    /**
     *证件号码信息不正确
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_IDNO_FORMATTER_ERROR = "MOBC25";

    /**
     *出生日期信息不正确
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_BIRTHDAY_FORMATTER_ERROR = "MOBC26";

    /**
     *手机号码格式不正确
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_PHONE_FORMATTER_ERROR = "MOBC27";

    /**
     *联系电话格式不正确
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_TELPHONE_FORMATTER_ERROR = "MOBC28";

    /**
     *邮政编码格式不正确
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_POSTCODE_FORMATTER_ERROR = "MOBC29";

    /**
     *通讯地址信息不正确，长度不能超过250个字符
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_ADDRESS_FORMATTER_ERROR = "MOBC30";

    /**
     *邮箱格式不正确
     */
    public final static String MOBILE_CARDTOP_EMAIL_FORMATTER_ERROR = "MOBC31";

    /**
     *会员特征信息有误
     */
    public final static String MOBILE_CARDTOP_MEMBER_FEATURE_INFO_FORMATTER_ERROR = "MOBC32";

    /**
     *已是商家会员卡
     */
    public final static String MOBILE_CARDTOP_APPLY_ELEC_CARD_ALREADY_IS_SHOP_MEMBER = "MOBC33";

    /**
     *用户已提交过申请
     */
    public final static String MOBILE_CARDTOP_ALREADY_SUBMIT_APPLY = "MOBC34";

    /**
     *申请实体卡电子化成功,请等待审核
     */
    public final static String MOBILE_CARDTOP_PHYCARD_CHANGE_ELEC_CARD_SUCCESS = "MOBC35";

    /**
     *申请实体卡电子化失败
     */
    public final static String MOBILE_CARDTOP_PHYCARD_CHANGE_ELEC_CARD_FAIL = "MOBC36";

    /**
     *修改会员信息成功
     */
    public final static String MOBILE_CARDTOP_UPD_MEMBER_INFO_SUCCESS = "MOBC37";

    /**
     *修改会员信息失败
     */
    public final static String MOBILE_CARDTOP_UPD_MEMBER_INFO_FAIL = "MOBC38";

    /**
     *用户没有此卡
     */
    public final static String MOBILE_CARDTOP_NOT_HAVE_THE_CARD = "MOBC39";

    /**
     *用户已有此卡
     */
    public final static String MOBILE_CARDTOP_ALREADY_HAVE_THE_CARD = "MOBC40";

    /**
     *发卡失败
     */
    public final static String MOBILE_CARDTOP_GIVE_CARD_FAIL = "MOBC41";

    /**
     *发卡成功
     */
    public final static String MOBILE_CARDTOP_GIVE_CARD_SUCCESS = "MOBC42";

    /**
     *删除用户收藏成功
     */
    public final static String MOBILE_CARDTOP_DEL_FAVORIATE_SUCCESS = "MOBC43";

    /**
     *删除用户收藏失败
     */
    public final static String MOBILE_CARDTOP_DEL_FAVORIATE_FAIL = "MOBC44";

    /**
     *当信息id有值时收藏信息类型不能为空
     */
    public final static String MOBILE_PARAMETER_SHOPADID_HAVE_VALUE_ADTYPE_IS_NULL = "MOBD01";

    /**
     *信息ID和信息的URL二选一不能为空
     */
    public final static String MOBILE_PARAMETER_SHOPADID_AND_ADURL_IS_NULL = "MOBD02";

    /**
     *优惠凭证与用户关联编号不能为空
     */
    public final static String MOBILE_PARAMETER_COUPONUSERID_IS_NULL = "MOBD03";

    /**
     *收藏类型不能为空
     */
    public final static String MOBILE_PARAMETER_FAVORIATETYPE_IS_NULL = "MOBD16";

    /**
     *分类编码不能为空
     */
    public final static String MOBILE_PARAMETER_TYPECODE_IS_NULL = "MOBD17";

    /**
     *收藏失败
     */
    public final static String MOBILE_FAVORIATE_STORE_FAIL = "MOBD04";

    /**
     *收藏成功
     */
    public final static String MOBILE_FAVORIATE_STORE_SUCCESS = "MOBD05";

    /**
     *已收藏过了,不允许再次收藏
     */
    public final static String MOBILE_FAVORIATE_ALREADY_STORE = "MOBD06";

    /**
     *收藏的信息不存在或已删除
     */
    public final static String MOBILE_FAVORIATE_STORE_INFO_DEL_OR_NOT_EXIST = "MOBD07";

    /**
     *用户收藏优惠券个数已达到最大拥有个数
     */
    public final static String MOBILE_FAVORIATE_STORE_NUM_EXCEED_MAX_OWN_NUMS = "MOBD08";

    /**
     *收藏的优惠券已过发行期，不允许收藏
     */
    public final static String MOBILE_FAVORIATE_EXCEED_PUBLISH_END_TIME = "MOBD09";

    /**
     *关注成功
     */
    public final static String MOBILE_FAVORIATE_ATTENTION_SHOP_SUCCESS = "MOBD10";

    /**
     *关注失败
     */
    public final static String MOBILE_FAVORIATE_ATTENTION_SHOP_FAIL = "MOBD11";

    /**
     *用户已关注过此商家
     */
    public final static String MOBILE_FAVORIATE_ALREADY_ATTENTION_SHOP = "MOBD12";

    /**
     *用户已是商家会员
     */
    public final static String MOBILE_FAVORIATE_ALREADY_IS_MEMBER_OF_SHOP = "MOBD13";

    /**
     *此商家不允许关注
     */
    public final static String MOBILE_FAVORIATE_SHOP_NOT_ALLOW_TO_ATTENTION = "MOBD14";

    /**
     *商家此优惠券已分发完毕
     */
    public final static String MOBILE_FAVORIATE_STORE_COUPON_FINISH_GIVING = "MOBD15";

    /**
     *查询吆喝类型不能为空
     */
    public final static String MOBILE_PARAMETER_CRYOUTTYPE_IS_NULL = "MOBE01";

    /**
     *当“查询吆喝类型”为“周边商家”时此维度不能为空
     */
    public final static String MOBILE_PARAMETER_CRYOUTTYPE_IS_D_GASX_IS_NULL = "MOBE02";

    /**
     *当“查询吆喝类型”为“周边商家”时此维度不能为空
     */
    public final static String MOBILE_PARAMETER_CRYOUTTYPE_IS_D_GASY_IS_NULL = "MOBE03";

    /**
     *查询商家吆喝成功
     */
    public final static String MOBILE_CRYOUT_QUERY_SHOPCRYOUT_SUCCESS = "MOBE04";

    /**
     *查询吆喝广场侧边栏分类成功
     */
    public final static String MOBILE_CRYOUT_QUERY_CRYOUTPLAZAMENU_SUCCESS = "MOBE05";

    /**
     *查询吆喝广场商家列表成功
     */
    public final static String MOBILE_CRYOUT_QUERY_SHOPLIST_OF_CRYOUTPLAZA_SUCCESS = "MOBE06";

    /**
     *查询吆喝广场商家详情成功
     */
    public final static String MOBILE_CRYOUT_QUERY_SHOPDETAIL_OF_CRYOUTPLAZA_SUCCESS = "MOBE07";

    /**
     *查询吆喝广场下精品推荐信息成功
     */
    public final static String MOBILE_CRYOUT_QUERY_BOUTIQUERECOMMEND_OF_CRYOUTPLAZA_SUCCESS = "MOBE08";

    /**
     *商品信息不能为空
     */
    public final static String MOBILE_PARAMETER_USERSHOPPINGPLAN_IS_NULL = "MOBF01";

    /**
     *查询时间不能为空
     */
    public final static String MOBILE_PARAMETER_DATE_IS_NULL = "MOBF02";

    /**
     *查询开始时间不能为空
     */
    public final static String MOBILE_PARAMETER_STARTDATE_IS_NULL = "MOBF03";

    /**
     *查询结束时间不能为空
     */
    public final static String MOBILE_PARAMETER_ENDDATE_IS_NULL = "MOBF04";

    /**
     *匹配关键字不能为空
     */
    public final static String MOBILE_PARAMETER_MATCH_KEYWORD_IS_NULL = "MOBF05";

    /**
     *计划列表与服务器同步成功
     */
    public final static String MOBILE_SHOPPINGPLAN_SYNCHRONIZE_SUCCESS = "MOBF06";

    /**
     *计划列表与服务器同步失败
     */
    public final static String MOBILE_SHOPPINGPLAN_SYNCHRONIZE_FAIL = "MOBF07";

    /**
     *查询用户“购物清单”中匹配商品的信息成功
     */
    public final static String MOBILE_SHOPPINGPLAN_MATCH_GOODSINFO_SUCCESS = "MOBF08";

    /**
     *查询活动信息成功
     */
    public final static String MOBILE_SHOPPINGPLAN_QUERY_ACTIVITY_SUCCESS = "MOBF09";

    /**
     *查询活动列表信息成功
     */
    public final static String MOBILE_SHOPPINGPLAN_QUERY_ACTIVITYLIST_SUCCESS = "MOBF10";

    /**
     *最大时间戳格式转换异常
     */
    public final static String SHOPPINGPLAN_CTIMESTAMP_FORMATTER_SWITCH_ERROR = "MOBF11";

    /**
     *购物匹配成功
     */
    public final static String MOBILE_SHOPPINGPLAN_SHOPPINGMATCH_SUCCESS = "MOBF12";

    /**
     *同步购物计划信息失败
     */
    public final static String MOBILE_SHOPPINGPLAN_SYN_INFO_FAIL = "MOBF13";

    /**
     *账单编号不能为空
     */
    public final static String MOBILE_PARAMETER_BILLID_IS_NULL = "MOBG01";

    /**
     *发票抬头不能为空
     */
    public final static String MOBILE_PARAMETER_INVOICEDTITLE_IS_NULL = "MOBG02";

    /**
     *发票类型不能为空
     */
    public final static String MOBILE_PARAMETER_INVOICE_TYPE_IS_NULL = "MOBG03";

    /**
     *发票项目名称不能为空
     */
    public final static String MOBILE_PARAMETER_INVOICEDITEM_IS_NULL = "MOBG04";

    /**
     *商品列表不能为空
     */
    public final static String MOBILE_PARAMETER_GOODSIDLIST_IS_NULL = "MOBG05";

    /**
     *桌号二维码不能为空
     */
    public final static String MOBILE_PARAMETER_TABLENO2D_IS_NULL = "MOBG06";

    /**
     *评分不能为空
     */
    public final static String MOBILE_PARAMETER_COMMENTLEVEL_IS_NULL = "MOBG07";

    /**
     *评论的具体内容不能为空
     */
    public final static String MOBILE_PARAMETER_CONTENT_IS_NULL = "MOBG08";

    /**
     *用餐人数不能为空
     */
    public final static String MOBILE_PARAMETER_NUMS_IS_NULL = "MOBG09";

    /**
     *排队号码不能为空
     */
    public final static String MOBILE_PARAMETER_QUEUENO_IS_NULL = "MOBG10";

    /**
     *商品自定义序列号不能为空
     */
    public final static String MOBILE_PARAMETER_ITEMSERIAL_IS_NULL = "MOBG11";

    /**
     *取货方式不能为空
     */
    public final static String MOBILE_PARAMETER_TAKEMETHOD_IS_NULL = "MOBG41";

    /**
     *提交开发票申请成功
     */
    public final static String MOBILE_BILL_SUBMIT_OPEN_INVOICE_APPLY_SUCCESS = "MOBG12";

    /**
     *提交开发票申请失败
     */
    public final static String MOBILE_BILL_SUBMIT_OPEN_INVOICE_APPLY_FAIL = "MOBG13";

    /**
     *已提交过开发票申请
     */
    public final static String MOBILE_BILL_ALREADY_SUBMIT_OPEN_INVOICE_APPLY = "MOBG14";

    /**
     *订单提交失败
     */
    public final static String MOBILE_BILL_SUBMIT_ORDER_FAIL = "MOBG15";

    /**
     *订单提交成功
     */
    public final static String MOBILE_BILL_SUBMIT_ORDER_SUCCESS = "MOBG16";

    /**
     *提交结帐申请成功
     */
    public final static String MOBILE_BILL_SUBMIT_PAY_BILL_SUCCESS = "MOBG17";

    /**
     *提交结帐申请失败
     */
    public final static String MOBILE_BILL_SUBMIT_PAY_BILL_FAIL = "MOBG18";

    /**
     *该订单已提交过结账申请
     */
    public final static String MOBILE_BILL_ALREADY_SUBMIT_PAY_BILL_FAIL = "MOBG19";

    /**
     *该订单已结账
     */
    public final static String MOBILE_BILL_THE_BILL_ALREADY_PAID = "MOBG20";

    /**
     *获取点菜单信息成功
     */
    public final static String MOBILE_BILL_DISH_MENU_SUCCESS = "MOBG21";

    /**
     *扫码取商品信息成功
     */
    public final static String MOBILE_BILL_SCAN_CODE_TO_GET_GOODSINFO_SUCCESS = "MOBG22";

    /**
     *评论成功
     */
    public final static String MOBILE_BILL_COMMENT_GOODS_SUCCESS = "MOBG23";

    /**
     *评论失败
     */
    public final static String MOBILE_BILL_COMMENT_GOODS_FAIL = "MOBG24";

    /**
     *餐桌状态查询成功
     */
    public final static String MOBILE_BILL_GET_TABLE_STATUS_SUCCESS = "MOBG25";

    /**
     *排号成功
     */
    public final static String MOBILE_BILL_QUEUE_SUCCESS = "MOBG26";

    /**
     *排号失败
     */
    public final static String MOBILE_BILL_QUEUE_FAIL = "MOBG27";

    /**
     *餐桌已够用无需排号
     */
    public final static String MOBILE_BILL_NOT_NEED_QUEUE = "MOBG28";

    /**
     *品类销售排行查询成功
     */
    public final static String MOBILE_BILL_GET_SALE_RANK_SUCCESS = "MOBG29";

    /**
     *桌号绑定订单失败
     */
    public final static String MOBILE_BILL_TABLENO_BIND_ORDER_FAIL = "MOBG30";

    /**
     *桌号绑定订单成功
     */
    public final static String MOBILE_BILL_TABLENO_BIND_ORDER_SUCCESS = "MOBG31";

    /**
     *获取订单信息成功
     */
    public final static String MOBILE_BILL_GET_ORDER_INFO_SUCCESS = "MOBG32";

    /**
     *刷新排号状态成功
     */
    public final static String MOBILE_BILL_REFRESH_TABLE_STATUS_SUCCESS = "MOBG33";

    /**
     *刷新排号状态失败
     */
    public final static String MOBILE_BILL_REFRESH_TABLE_STATUS_FAIL = "MOBG34";

    /**
     *号码已过
     */
    public final static String MOBILE_BILL_QUEUENO_LOSE_EFFECTIVE = "MOBG35";

    /**
     *提交加菜申请成功 
     */
    public final static String MOBILE_BILL_SUBMIT_ADD_BILL_APPLY_SUCCESS = "MOBG36";

    /**
     *提交加菜申请失败
     */
    public final static String MOBILE_BILL_SUBMIT_ADD_BILL_APPLY_FAIL = "MOBG37";

    /**
     *您已结账，请重新下单
     */
    public final static String MOBILE_BILL_ALREADY_PAID_BILL_SUBMIT_BILL_AGAIN = "MOBG39";

    /**
     *餐桌已被占用，请更换餐桌后提交订单
     */
    public final static String MOBILE_BILL_TABLE_IS_USE_PLEASE_CHANGE = "MOBG40";

    /**
     *用户已评论过此商品
     */
    public final static String MOBILE_BILL_USER_ALREADY_COMMENT_THE_GOODS = "MOBG42";

    /**
     *你已经排过号了
     */
    public final static String MOBILE_BILL_ALREADY_ARRANG = "MOBG43";

    /**
     *该订单号不存在
     */
    public final static String MOBILE_BILL_BILLID_IS_NOT_EXIST = "MOBG44";

    /**
     *订单已经结账
     */
    public final static String MOBILE_BILL_ALREADY_PAID = "MOBG45";

    /**
     *支付异常
     */
    public final static String MOBILE_BILL_THIRD_PAID_ERROR = "MOBG46";

    /**
     *网络异常
     */
    public final static String MOBILE_BILL_INTERNET_ERROR = "MOBG47";

    /**
     *支付失败
     */
    public final static String MOBILE_BILL_PAID_FAIL = "MOBG48";

    /**
     *用户登录账户不能为空
     */
    public final static String MOBILE_PARAMETER_ACCOUNT_IS_NULL = "MOBH01";

    /**
     *密码不能为空
     */
    public final static String MOBILE_PARAMETER_PASSWORD_IS_NULL = "MOBH02";

    /**
     *用户邮箱不能为空
     */
    public final static String MOBILE_PARAMETER_EMAIL_IS_NULL = "MOBH03";

    /**
     *原密码不能为空
     */
    public final static String MOBILE_PARAMETER_OLDPASSWORD_IS_NULL = "MOBH04";

    /**
     *新密码不能为空
     */
    public final static String MOBILE_PARAMETER_NEWPASSWORD_IS_NULL = "MOBH05";

    /**
     *反馈内容不能为空
     */
    public final static String MOBILE_PARAMETER_FEEDBACT_CONTENT_IS_NULL = "MOBH06";

    /**
     *验证码不能为空
     */
    public final static String MOBILE_PARAMETER_VERIFYCODE_IS_NULL = "MOBH07";

    /**
     *程序版本不能为空
     */
    public final static String MOBILE_PARAMETER_MVER_IS_NULL = "MOBH48";

    /**
     *系统类型不能为空
     */
    public final static String MOBILE_PARAMETER_MTYPE_IS_NULL = "MOBH49";

    /**
     *APP识别码不能为空
     */
    public final static String MOBILE_PARAMETER_APPCODE_IS_NULL = "MOBH51";

    /**
     *登陆成功
     */
    public final static String MOBILE_SET_LOGIN_SUCCESS = "MOBH08";

    /**
     *登陆失败
     */
    public final static String MOBILE_SET_LOGIN_FAIL = "MOBH09";

    /**
     *请先登录
     */
    public final static String MOBILE_SET_PLEASE_LOGIN = "MOBH10";

    /**
     *用户账号不存在
     */
    public final static String MOBILE_SET_ACCOUNT_NOT_EXIST = "MOBH11";

    /**
     *用户帐号尚未激活
     */
    public final static String MOBILE_SET_ACCOUNT_NOT_ACTIVE = "MOBH12";

    /**
     *用户帐号状态已锁定
     */
    public final static String MOBILE_SET_ACCOUNT_IS_LOCKED = "MOBH13";

    /**
     *用户账号密码不正确
     */
    public final static String MOBILE_SET_ACCOUNT_PASSWORD_ERROR = "MOBH14";

    /**
     *邮件发送失败
     */
    public final static String MOBILE_SET_SEND_EMAIL_FAIL = "MOBH15";

    /**
     *邮件已发送，请注意查收
     */
    public final static String MOBILE_SET_SEND_EMAIL_SUCCESS = "MOBH16";

    /**
     *该邮箱已被注册
     */
    public final static String MOBILE_SET_USEREMAIL_ALREADY_REGISTER = "MOBH17";

    /**
     *注册失败
     */
    public final static String MOBILE_SET_REGIST_FAIL = "MOBH18";

    /**
     *注册成功
     */
    public final static String MOBILE_SET_REGIST_SUCCESS = "MOBH19";

    /**
     *注册成功,请查收邮件,激活后登录
     */
    public final static String MOBILE_SET_REGIST_SUCCESS_PLEASE_ACTIVE = "MOBH20";

    /**
     *邮箱格式不正确
     */
    public final static String MOBILE_SET_REGIST_EMAIL_FORMATTER_ERROR = "MOBH21";

    /**
     *密码长度只能在6-20个字符之间
     */
    public final static String MOBILE_SET_REGIST_PASSWORD_LENGTH_BETWEEN_6_AND_20 = "MOBH22";

    /**
     *原始密码不正确
     */
    public final static String MOBILE_SET_ORG_PASSWORD_ERROR = "MOBH23";

    /**
     *新密码长度只能在6-20个字符之间
     */
    public final static String MOBILE_SET_UPD_PASSWORD_NEWPASS_LENGTH_BETWEEN_6_AND_20 = "MOBH24";

    /**
     *修改密码失败
     */
    public final static String MOBILE_SET_UPD_PASSWORD_FAIL = "MOBH25";

    /**
     *修改密码成功
     */
    public final static String MOBILE_SET_UPD_PASSWORD_SUCCESS = "MOBH26";

    /**
     *修改用户基本信息失败
     */
    public final static String MOBILE_SET_UPD_BASEINFO_FAIL = "MOBH27";

    /**
     *用户更改基本信息成功
     */
    public final static String MOBILE_SET_UPD_BASEINFO_SUCCESS = "MOBH28";

    /**
     *姓名格式不正确
     */
    public final static String MOBILE_SET_UPD_NAME_FORMATTER_ERROR = "MOBH29";

    /**
     *性别格式不正确
     */
    public final static String MOBILE_SET_UPD_SEX_FORMATTER_ERROR = "MOBH30";

    /**
     *该证件类型不存在
     */
    public final static String MOBILE_SET_UPD_IDTYPE_FORMATTER_ERROR = "MOBH31";

    /**
     *证件号码格式不正确
     */
    public final static String MOBILE_SET_UPD_IDNO_FORMATTER_ERROR = "MOBH32";

    /**
     *出生日期格式不正确
     */
    public final static String MOBILE_SET_UPD_BIRTHDAY_FORMATTER_ERROR = "MOBH33";

    /**
     *联系电话格式不正确
     */
    public final static String MOBILE_SET_UPD_PHONE_FORMATTER_ERROR = "MOBH34";

    /**
     *邮政编码格式不正确
     */
    public final static String MOBILE_SET_UPD_POSTCODE_FORMATTER_ERROR = "MOBH35";

    /**
     *详细地址格式不正确
     */
    public final static String MOBILE_SET_UPD_ADDRESS_FORMATTER_ERROR = "MOBH36";

    /**
     *查询用户基本信息失败
     */
    public final static String MOBILE_SET_GET_BASEINFO_FAIL = "MOBH37";

    /**
     *查询用户基本信息成功
     */
    public final static String MOBILE_SET_GET_BASEINFO_SUCCESS = "MOBH38";

    /**
     *意见反馈失败
     */
    public final static String MOBILE_SET_FEEDBACK_FAIL = "MOBH39";

    /**
     *意见反馈成功
     */
    public final static String MOBILE_SET_FEEDBACK_SUCCESS = "MOBH40";

    /**
     *获取gooagooid失败
     */
    public final static String MOBILE_SET_GET_GOOAGOOID_FAIL = "MOBH41";

    /**
     *获取gooagooid成功
     */
    public final static String MOBILE_SET_GET_GOOAGOOID_SUCCESS = "MOBH42";

    /**
     *获取短信验证码失败
     */
    public final static String MOBILE_SET_GET_SHORTMESSAGE_VERIFYCODE_FAIL = "MOBH43";

    /**
     *获取短信验证码成功
     */
    public final static String MOBILE_SET_GET_SHORTMESSAGE_VERIFYCODE_SUCCESS = "MOBH44";

    /**
     *手机号码格式不正确
     */
    public final static String MOBILE_SET_PHONE_FORMATTER_ERROR = "MOBH45";

    /**
     *短信验证码不正确
     */
    public final static String MOBILE_SET_SHORTMESSAGE_CHECK_ERROR = "MOBH46";

    /**
     *该手机号码已被注册
     */
    public final static String MOBILE_SET_PHONE_ALREADY_REGISTER = "MOBH47";

    /**
     *App已是最新版本
     */
    public final static String MOBILE_SET_APP_IS_THE_LAST_VERSION = "MOBH50";

    /**
     *同步方式不能为空
     */
    public final static String MOBILE_PARAMETER_SYNINFO_WAY_IS_NULL = "MOBI01";

    /**
     *当同步方式为1时，同步信息不能为空
     */
    public final static String MOBILE_PARAMETER_WAY_IS_1_SYNINFO_IS_NULL = "MOBI02";

    /**
     *当同步方式为2时，实体店编号不能为空
     */
    public final static String MOBILE_PARAMETER_WAY_IS_2_SHOPENTITYID_IS_NULL = "MOBI03";

    /**
     *同步范围不能为空
     */
    public final static String MOBILE_PARAMETER_CONTAINCODE_IS_NULL = "MOBI04";

    /**
     *同步范围类型不正确
     */
    public final static String MOBILE_PARAMETER_CONTAINCODE_ERROR = "MOBI05";

    /**
     *记录用户使用手机行为失败
     */
    public final static String MOBILE_BEHAVE_TRACK_FAIL = "MOBL01";

    /**
     *记录用户使用手机行为成功
     */
    public final static String MOBILE_BEHAVE_TRACK_SUCCESS = "MOBL02";

    /**
     *查询日期时间不能为空
     */
    public final static String MOBILE_PARAMETER_COUSUME_DATE_IS_NULL = "MOBM01";

    /**
     *提货凭证编号有误
     */
    public final static String MOBILE_PARAMETER_VOUCHERID_IS_NULL = "MOBN01";

    /**
     *音频信息有误
     */
    public final static String MOBILE_AUDIO_INFO_ERROR = "MOBN02";

    /**
     *请使用本店会员卡
     */
    public final static String MOBILE_AUDIO_CARD_NOT_PRESENT_SHOP_CARD = "MOBN03";

    /**
     *该卡已经过期
     */
    public final static String MOBILE_AUDIO_CARD_MEMBER_CARD_OVER_TIME = "MOBN04";

    /**
     *该卡不存在
     */
    public final static String MOBILE_AUDIO_CARD_IS_NOT_EXIST = "MOBN05";

    /**
     *请使用本人的会员卡
     */
    public final static String MOBILE_AUDIO_CARD_NOT_BELONG_USER = "MOBN06";

    /**
     *购物车编号不能为空
     */
    public final static String MOBILE_PARAMETER_SHOPPINGCHARTID_IS_NULL = "MOBO01";

    /**
     *商品数量不能为空
     */
    public final static String MOBILE_PARAMETER_GOODSNUM_IS_NULL = "MOBO02";

    /**
     *添加商品失败
     */
    public final static String MOBILE_SHOPPINGCART_ADD_GOODS_FAIL = "MOBO03";

    /**
     *编辑商品信息失败
     */
    public final static String MOBILE_SHOPPINGCART_EDIT_GOODS_FAIL = "MOBO04";

    /**
     *删除商品失败
     */
    public final static String MOBILE_SHOPPINGCART_DEL_GOODS_FAIL = "MOBO05";

    /**
     *手机接口提示信息（mobile）--END
     */

}
