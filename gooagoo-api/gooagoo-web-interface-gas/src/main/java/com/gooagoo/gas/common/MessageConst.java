package com.gooagoo.gas.common;

public final class MessageConst
{
    /**
     *店员助理提示信息(gas)--START
     */

    /**
     *店员助理MAC地址不能为空
     */
    public final static String GAS_PARAMETER_MAC_IS_NULL = "GASA01";

    /**
     *会员卡号不能为空
     */
    public final static String GAS_PARAMETER_SCARDNO_IS_NULL = "GASA02";

    /**
     *店员登录账号不能为空
     */
    public final static String GAS_PARAMETER_SHOPUSERID_IS_NULL = "GASA03";

    /**
     *用户编号不能为空
     */
    public final static String GAS_PARAMETER_USERID_IS_NULL = "GASA04";

    /**
     *商家编号不能为空
     */
    public final static String GAS_PARAMETER_SHOPID_IS_NULL = "GASA05";

    /**
     *桌号不能为空
     */
    public final static String GAS_PARAMETER_TABLENAME_IS_NULL = "GASA06";

    /**
     *实体店编号不能为空
     */
    public final static String GAS_PARAMETER_SHOPENTITYID_IS_NULL = "GASA07";

    /**
     *菜品类别编号不能为空
     */
    public final static String GAS_PARAMETER_FOOD_CATEGORYID_IS_NULL = "GASA08";

    /**
     *订单编号不能为空
     */
    public final static String GAS_PARAMETER_ORDERID_IS_NULL = "GASA09";

    /**
     *优惠凭证编号不能为空
     */
    public final static String GAS_PARAMETER_COUPONID_IS_NULL = "GASA10";

    /**
     *商品自定义序列号不能为空
     */
    public final static String GAS_PARAMETER_ITEMSERIAL_IS_NULL = "GASA11";

    /**
     *账单编号不能为空
     */
    public final static String GAS_PARAMETER_BILLID_IS_NULL = "GASA12";

    /**
     *商品名称和商品自定义序列号不能同时为空
     */
    public final static String GAS_PARAMETER_ITEMSERIAL_AND_GOODSNAME_IS_NULL = "GASA13";

    /**
     *商品品类名称不能为空
     */
    public final static String GAS_PARAMETER_GOOD_CATEGORYNAME_IS_NULL = "GASA14";

    /**
     *商品品类编号不能为空
     */
    public final static String GAS_PARAMETER_GOOD_CATEGORYID_IS_NULL = "GASA15";

    /**
     *页码不能为空
     */
    public final static String GAS_PARAMETER_PAGEINDEX_IS_NULL = "GASA16";

    /**
     *页码不能为空
     */
    public final static String GAS_PARAMETER_PAGESIZE_IS_NULL = "GASA17";

    /**
     *商品信息不能为空
     */
    public final static String GAS_PARAMETER_GOODSINFO_IS_NULL = "GASA18";

    /**
     *查询成功
     */
    public final static String GAS_COMMON_QUERY_SUCCESS = "GASB01";

    /**
     *查询失败
     */
    public final static String GAS_COMMON_QUERY_FAIL = "GASB02";

    /**
     *未查询到符合条件的数据
     */
    public final static String GAS_COMMON_NOT_GET_WANT_DATA = "GASB03";

    /**
     *删除成功
     */
    public final static String GAS_COMMON_DEL_DATA_SUCCESS = "GASB04";

    /**
     *删除失败
     */
    public final static String GAS_COMMON_DEL_DATA_FAIL = "GASB05";

    /**
     *提交成功
     */
    public final static String GAS_COMMON_SUBMIT_DATA_SUCCESS = "GASB06";

    /**
     *提交失败
     */
    public final static String GAS_COMMON_SUBMIT_DATA_FAIL = "GASB07";

    /**
     *系统异常
     */
    public final static String GAS_COMMON_SYSTEM_EXCEPTION = "GASB08";

    /**
     *密码不能为空
     */
    public final static String GAS_PARAMETER_PASSWORD_IS_NULL = "GASC01";

    /**
     *登录成功
     */
    public final static String GAS_LOGIN_SUCCESS = "GASC02";

    /**
     *登录失败
     */
    public final static String GAS_LOGIN_FAIL = "GASC03";

    /**
     *店员登录账号或者密码为空
     */
    public final static String GAS_LOGIN_ACCOUNT_OR_PASSWORD_IS_NULL = "GASC04";

    /**
     *店员登录账号不存在
     */
    public final static String GAS_LOGIN_ACCOUNT_IS_NOT_EXIST = "GASC05";

    /**
     *店员登录账号密码不正确
     */
    public final static String GAS_LOGIN_ACCOUNT_ERROR = "GASC06";

    /**
     *店员登录账号已锁定
     */
    public final static String GAS_LOGIN_ACCOUNT_LOCKED = "GASC07";

    /**
     *店员登录账号异常,请联系管理员
     */
    public final static String GAS_LOGIN_ACCOUNT_EXCEPTION = "GASC08";

    /**
     *餐桌类型不能为空
     */
    public final static String GAS_PARAMETER_DESKTYPE_IS_NULL = "GASD01";

    /**
     *就餐人数
     */
    public final static String GAS_PARAMETER_QUEUENUMS_IS_NULL = "GASD02";

    /**
     *排队号码不能为空
     */
    public final static String GAS_PARAMETER_QUEUE_IS_NULL = "GASD03";

    /**
     *换到桌号不能为空
     */
    public final static String GAS_PARAMETER_EXCHANGE_TO_TABLENAME_IS_NULL = "GASD17";

    /**
     *换台桌号不能为空
     */
    public final static String GAS_PARAMETER_EXCHANGE_FROM_TABLENAME_IS_NULL = "GASD18";

    /**
     *并到桌号不能为空
     */
    public final static String GAS_PARAMETER_MERGE_TO_TABLENAME_IS_NULL = "GASD19";

    /**
     *并台桌号不能为空
     */
    public final static String GAS_PARAMETER_MERGE_FROM_TABLENAME_IS_NULL = "GASD20";

    /**
     *餐桌已够用无需排号
     */
    public final static String GAS_QUEUE_DESK_FULFIL_USE = "GASD04";

    /**
     *排号失败
     */
    public final static String GAS_QUEUE_ADD_FAIL = "GASD05";

    /**
     *排号成功
     */
    public final static String GAS_QUEUE_ADD_SUCCESS = "GASD06";

    /**
     *销号失败
     */
    public final static String GAS_QUEUE_DEL_FAIL = "GASD07";

    /**
     *销号成功
     */
    public final static String GAS_QUEUE_DEL_SUCCESS = "GASD08";

    /**
     *你已经排过号了
     */
    public final static String GAS_QUEUE_ALREADY_ARRANG = "GASD21";

    /**
     *开台成功
     */
    public final static String GAS_TABLE_OPEN_SUCCESS = "GASD09";

    /**
     *开台失败
     */
    public final static String GAS_TABLE_OPEN_FAIL = "GASD10";

    /**
     *清台成功
     */
    public final static String GAS_TABLE_CLEAR_SUCCESS = "GASD11";

    /**
     *清台失败
     */
    public final static String GAS_TABLE_CLEAR_FAIL = "GASD12";

    /**
     *并台成功
     */
    public final static String GAS_TABLE_MERGE_SUCCESS = "GASD13";

    /**
     *并台失败
     */
    public final static String GAS_TABLE_MERGE_FAIL = "GASD14";

    /**
     *换台成功
     */
    public final static String GAS_TABLE_EXCHANGE_SUCCESS = "GASD15";

    /**
     *换台失败
     */
    public final static String GAS_TABLE_EXCHANGE_FAIL = "GASD16";

    /**
     *点餐信息json数组字符串不能为空
     */
    public final static String GAS_PARAMETER_DESKJSON_IS_NULL = "GASE01";

    /**
     *已上菜品信息不能为空
     */
    public final static String GAS_PARAMETER_FOODSINFO_IS_NULL = "GASE02";

    /**
     *用餐人数不能为空
     */
    public final static String GAS_PARAMETER_PEOPLENUMS_IS_NULL = "GASE16";

    /**
     *菜品重量不能为空
     */
    public final static String GAS_PARAMETER_GOODSWEIGHT_IS_NULL = "GASE17";

    /**
     *菜品编号不能为空
     */
    public final static String GAS_PARAMETER_FOODSID_IS_NULL = "GTSE28";

    /**
     *取货方式不能为空
     */
    public final static String GAS_PARAMETER_TAKEMETHOD_IS_NULL = "GTSE31";

    /**
     *提交结账申请失败
     */
    public final static String GAS_BILL_ADD_APLLY_FAIL = "GASE03";

    /**
     *结账申请已经提交过了
     */
    public final static String GAS_BILL_APLLY_ALREADY_SUBMIT = "GASE04";

    /**
     *提交订单失败
     */
    public final static String GAS_BILL_ADD_FAIL = "GASE05";

    /**
     *用餐时间处理有误
     */
    public final static String GAS_BILL_MEAL_TIME_DEAL_ERROR = "GASE06";

    /**
     *提交订单成功
     */
    public final static String GAS_BILL_ADD_SUCCESS = "GASE07";

    /**
     *订单数据格式或数据内容有误
     */
    public final static String GAS_BILL_ORDERDATA_FORMATTER_OR_CONTENT_ERROR = "GASE08";

    /**
     *账单数据格式或数据内容有误
     */
    public final static String GAS_BILL_BILLDATA_FORMATTER_OR_CONTENT_ERROR = "GASE09";

    /**
     *发票申请已经提交过了
     */
    public final static String GAS_BILL_INVOICE_APLLY_ALREADY_SUBMIT = "GASE10";

    /**
     *该用户已结账，需重新下单
     */
    public final static String GAS_BILL_ALREADY_PAID_BILL_NEED_SUBMIT_AGAIN = "GASE11";

    /**
     *该用户已结账，不能减菜
     */
    public final static String GAS_BILL_ALREADY_PAID_BILL_UNABLE_SUB_DISH = "GASE12";

    /**
     *加菜失败
     */
    public final static String GAS_BILL_ADD_DISH_FAIL = "GASE13";

    /**
     *减菜失败
     */
    public final static String GAS_BILL_SUB_DISH_FAIL = "GASE14";

    /**
     *最大时间戳格式不正确
     */
    public final static String GAS_BILL_CTIMESTAMP_FORMATTER_ERROR = "GASE15";

    /**
     *提交起菜请成功
     */
    public final static String GAS_BILL_SUBMIT_ORDER_DISH_APPLY_SUCCESS = "GASE18";

    /**
     *提交起菜请失败
     */
    public final static String GAS_BILL_SUBMIT_ORDER_DISH_APPLY_FAIL = "GASE19";

    /**
     *提交催菜请求成功
     */
    public final static String GAS_BILL_SUBMIT_HURRY_DISH_APPLY_SUCCESS = "GASE20";

    /**
     *提交催菜请求失败
     */
    public final static String GAS_BILL_SUBMIT_HURRY_DISH_APPLY_FAIL = "GASE21";

    /**
     *提交缓菜请求成功
     */
    public final static String GAS_BILL_SUBMIT_SLOW_DISH_APPLY_SUCCESS = "GASE22";

    /**
     *提交缓菜请求失败
     */
    public final static String GAS_BILL_SUBMIT_SLOW_DISH_APPLY_FAIL = "GASE23";

    /**
     *修改台头信息成功
     */
    public final static String GAS_BILL_UPD_HAVA_DINNER_INFO_SUCCESS = "GASE24";

    /**
     *修改台头信息失败
     */
    public final static String GAS_BILL_UPD_HAVA_DINNER_INFO_FAIL = "GASE25";

    /**
     *提交重量确认信息成功
     */
    public final static String GAS_BILL_SUBMIT_WEIGHT_CONFIRM_SUCCESS = "GASE26";

    /**
     *提交重量确认信息失败
     */
    public final static String GAS_BILL_SUBMIT_WEIGHT_CONFIRM_FAIL = "GASE27";

    /**
     *没有此餐桌，请输入正确的餐桌号
     */
    public final static String GAS_BILL_TABLENAME_IS_NOT_EXIST = "GTSE29";

    /**
     *餐桌已被占用，请更换餐桌后提交订单
     */
    public final static String GAS_BILL_TABLE_IS_USE_PLEASE_CHANGE = "GTSE30";

    /**
     *换到餐桌已被占用，请选择其它餐桌换台
     */
    public final static String GAS_BILL_TABLE_IS_USE_PLEASE_CHOOSE_OTHER = "GTSE32";

    /**
     *菜品名称或者编号不能为空
     */
    public final static String GAS_PARAMETER_FOODNAME_OR_ID_IS_NULL = "GASF01";

    /**
     *未查询到符合条件的会员卡与用户关信息
     */
    public final static String GAS_CARD_LINK_MEMBER_FAIL = "GASG01";

    /**
     *请使用本店会员卡
     */
    public final static String GAS_CARD_NOT_PRESENT_SHOP_CARD = "GASG02";

    /**
     *该卡已经过期
     */
    public final static String GAS_CARD_MEMBER_CARD_OVER_TIME = "GASG03";

    /**
     *该卡不存在
     */
    public final static String GAS_CARD_IS_NOT_EXIST = "GASG04";

    /**
     *区域编号不能为空
     */
    public final static String GAS_PARAMETER_POSITIONID_IS_NULL = "GASH01";

    /**
     *店员助理mac地址不存在或者不正确
     */
    public final static String GAS_SHOP_MAC_NOT_EXIST_OR_ERROR = "GASI01";

    /**
     *传入的商家编号不正确，不是当前商家的商家编号
     */
    public final static String GAS_SHOP_SHOP_ERROR = "GASI02";

    /**
     *店员助理mac地址和店员登录账号所属实体店匹配不上
     */
    public final static String GAS_SHOP_NOT_BELONG_THE_SAME_SHOPENTITY = "GASI03";

    /**
     *店员登录账号不存在或已被删除
     */
    public final static String GAS_SHOP_SHOPUSERID_NOT_EXIST_OR_DEL = "GASI04";

    /**
     *店员登录账号异常，填写的管辖品牌信息不存在
     */
    public final static String GAS_SHOP_SHOPUSERID_MANAGE_BRAND_EXCEPTION = "GASI05";

    /**
     *店员登录密码不正确
     */
    public final static String GAS_SHOP_SHOPUSER_PASSWORD_ERROR = "GASI06";

    /**
     *发票类型不能为空
     */
    public final static String GAS_PARAMETER_INVOICE_TYPE_IS_NULL = "GASJ01";

    /**
     *发票抬头不能为空
     */
    public final static String GAS_PARAMETER_INVOICE_TITLE_IS_NULL = "GASJ02";

    /**
     *店员助理提示信息(gas)--END
     */

}
