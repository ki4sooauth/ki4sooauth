package com.gooagoo.trans.common;

public final class MessageConst
{
    /**
     *转发器接口提示信息(trans)--START
     */

    /**
     *转发器MAC地址不能为空
     */
    public final static String TRANS_PARAMETER_MAC_IS_NULL = "GTSA01";

    /**
     *商家编号不能为空
     */
    public final static String TRANS_PARAMETER_SHOPID_IS_NULL = "GTSA02";

    /**
     *最大时间戳不能为空
     */
    public final static String TRANS_PARAMETER_CTIMESTAMP_IS_NULL = "GTSA03";

    /**
     *查询成功
     */
    public final static String TRANS_COMMON_QUERY_SUCCESS = "GTSB01";

    /**
     *查询失败
     */
    public final static String TRANS_COMMON_QUERY_FAIL = "GTSB02";

    /**
     *未查询到符合条件的数据
     */
    public final static String TRANS_COMMON_NOT_GET_WANT_DATA = "GTSB03";

    /**
     *删除成功
     */
    public final static String TRANS_COMMON_DEL_DATA_SUCCESS = "GTSB04";

    /**
     *删除失败
     */
    public final static String TRANS_COMMON_DEL_DATA_FAIL = "GTSB05";

    /**
     *提交成功
     */
    public final static String TRANS_COMMON_SUBMIT_DATA_SUCCESS = "GTSB06";

    /**
     *提交失败
     */
    public final static String TRANS_COMMON_SUBMIT_DATA_FAIL = "GTSB07";

    /**
     *系统异常
     */
    public final static String TRANS_COMMON_SYSTEM_EXCEPTION = "GTSB08";

    /**
     *会员卡号不能为空
     */
    public final static String TRANS_PARAMETER_SCARDNO_IS_NULL = "GTSC01";

    /**
     *桌号不能为空
     */
    public final static String TRANS_PARAMETER_DESKNO_IS_NULL = "GTSC02";

    /**
     *账单信息不能为空
     */
    public final static String TRANS_PARAMETER_BILL_IS_NULL = "GTSC03";

    /**
     *订单信息不能为空
     */
    public final static String TRANS_PARAMETER_ORDER_IS_NULL = "GTSC04";

    /**
     *实体店编号不能为空
     */
    public final static String TRANS_PARAMETER_SHOPENTITYID_IS_NULL = "GTSC05";

    /**
     *餐桌类型不能为空
     */
    public final static String TRANS_PARAMETER_DESKTYPE_IS_NULL = "GTSC06";

    /**
     *处理状态不能为空
     */
    public final static String TRANS_PARAMETER_APPLYSTATUS_IS_NULL = "GTSC07";

    /**
     *订单类型不能为空
     */
    public final static String TRANS_PARAMETER_TYPE_IS_NULL = "GTSC08";

    /**
     *是否同意信息不能为空
     */
    public final static String TRANS_PARAMETER_AGREETYPE_IS_NULL = "GTSC09";

    /**
     *排队号码不能为空
     */
    public final static String TRANS_PARAMETER_QUEUENO_IS_NULL = "GTSC10";

    /**
     *发票抬头不能为空
     */
    public final static String TRANS_PARAMETER_INVOICE_TITLE_IS_NULL = "GTSC11";

    /**
     *账单编号和订单编号不能同时为空
     */
    public final static String TRANS_PARAMETER_BILLID_AND_ORDERID_IS_NULL = "GTSC12";

    /**
     *订单编号不能为空
     */
    public final static String TRANS_PARAMETER_ORDERID_IS_NULL = "GTSC13";

    /**
     *用户编号不能为空
     */
    public final static String TRANS_PARAMETER_USERID_IS_NULL = "GTSC14";

    /**
     *账单编号不能为空
     */
    public final static String TRANS_PARAMETER_BILLID_IS_NULL = "GTSC15";

    /**
     *商品自定义序列号
     */
    public final static String TRANS_PARAMETER_ITEMSERIAL_IS_NULL = "GTSC16";

    /**
     *页码不能为空
     */
    public final static String TRANS_PARAMETER_PAGEINDEX_IS_NULL = "GTSC17";

    /**
     *每页信息显示条数不能为空
     */
    public final static String TRANS_PARAMETER_PAGESIZE_IS_NULL = "GTSC18";

    /**
     *账单明细信息不能为空
     */
    public final static String TRANS_PARAMETER_BILLDETAIL_IS_NULL = "GTSC36";

    /**
     *餐桌状态信息不能为空
     */
    public final static String TRANS_PARAMETER_TABLESSTATUSINFO_IS_NULL = "GTSC37";

    /**
     *最大时间戳和账单明细信息不能同时为空
     */
    public final static String TRANS_PARAMETER_CTIMESTAMP_AND_DATADETAIL_IS_NULL = "GTSC38";

    /**
     *第三方订单编号不能为空
     */
    public final static String TRANS_PARAMETER_BILLNO_IS_NULL = "GTSC45";

    /**
     *商家账单入库失败
     */
    public final static String TRANS_BILL_ADD_SHOP_BILL_FAIL = "GTSC19";

    /**
     *商家订单入库失败
     */
    public final static String TRANS_BILL_ADD_SHOP_ORDER_FAIL = "GTSC20";

    /**
     *用户订单入库失败
     */
    public final static String TRANS_BILL_ADD_USER_ORDER_FAIL = "GTSC21";

    /**
     *用户订单明细信息入库失败
     */
    public final static String TRANS_BILL_ADD_USER_ORDER_DETAIL_FAIL = "GTSC22";

    /**
     *商家账单详情入库失败
     */
    public final static String TRANS_BILL_ADD_SHOP_BILLDETAIL_FAIL = "GTSC23";

    /**
     *商家账单详情入库成功
     */
    public final static String TRANS_BILL_ADD_SHOP_ORDERDETAIL_FAIL = "GTSC24";

    /**
     *最大时间戳格式不正确
     */
    public final static String TRANS_BILL_CTIMESTAMP_FORMATTER_ERROR = "GTSC25";

    /**
     *消费日期由字符型转换为日期型出错
     */
    public final static String TRANS_BILL_COSUMEDATE_TRANSFORM_ERROR = "GTSC26";

    /**
     *商家账单数据上传失败
     */
    public final static String TRANS_BILL_UPLOAD_SHOP_BILL_DATA_FAIL = "GTSC27";

    /**
     *商家订单数据上传失败
     */
    public final static String TRANS_BILL_UPLOAD_SHOP_ORDER_DATA_FAIL = "GTSC28";

    /**
     *用户未使用优惠券
     */
    public final static String TRANS_BILL_USER_NOT_USE_COUPON = "GTSC29";

    /**
     *优惠券确认失败
     */
    public final static String TRANS_BILL_COUPON_CHECK_FAIL = "GTSC30";

    /**
     *销号失败
     */
    public final static String TRANS_BILL_CANCEL_QUEUENO_FAIL = "GTSC31";

    /**
     *销号成功
     */
    public final static String TRANS_BILL_CANCEL_QUEUENO_SUCCESS = "GTSC32";

    /**
     *优惠券锁定失败
     */
    public final static String TRANS_BILL_LOCK_COUPON_FAIL = "GTSC33";

    /**
     *优惠券解锁失败
     */
    public final static String TRANS_BILL_UNLOCK_COUPON_FAIL = "GTSC34";

    /**
     *转发器mac地址不存在或不正确
     */
    public final static String TRANS_BILL_MAC_ERROR = "GTSC35";

    /**
     *开发票确认失败
     */
    public final static String TRANS_BILL_OPEN_INVOICE_CONFIRM_FAIL = "GTSC39";

    /**
     *上传博立协议的账单明细信息失败
     */
    public final static String TRANS_BILL_UPLOAD_THIRDSHOP_BILLDETAIL_FAIL = "GTSC40";

    /**
     *上传博立协议的沽清列表失败
     */
    public final static String TRANS_BILL_UPLOAD_THIRDSHOP_ESTIMATELIST_FAIL = "GTSC41";

    /**
     *上传博立协议房台汇总信息失败
     */
    public final static String TRANS_BILL_UPLOAD_THIRDSHOP_TOTAL_TABLESTATUS_FAIL = "GTSC42";

    /**
     *卡号不存在
     */
    public final static String TRANS_BILL_CARD_IS_NOT_EXIST = "GTSC43";

    /**
     *订单不存在
     */
    public final static String TRANS_BILL_BILL_IS_NOT_EXIST = "GTSC44";

    /**
     *网络异常
     */
    public final static String TRANS_BILL_INTERNET_ERROR = "GTSC46";

    /**
     *请使用本店会员卡
     */
    public final static String TRANS_BILL_CARD_NOT_PRESENT_SHOP_CARD = "GTSC47";

    /**
     *该设备信息不存在，不能初始化
     */
    public final static String TRANS_SYS_DEVICE_INFO_NOT_EXIST = "GTSE01";

    /**
     *该设备已停用，不能初始化
     */
    public final static String TRANS_SYS_DEVICE_IS_STOP = "GTSE02";

    /**
     *该设备已损坏，不能初始化
     */
    public final static String TRANS_SYS_DEVICE_IS_BROKEN = "GTSE03";

    /**
     *商家状态异常，设备不能初始化
     */
    public final static String TRANS_SYS_SHOP_EXCEPTION = "GTSE04";

    /**
     *实体店状态异常，设备不能初始化
     */
    public final static String TRANS_SYS_SHOPENTITYID_EXCEPTION = "GTSE05";

    /**
     *优惠凭证编号不能为空
     */
    public final static String TRANS_PARAMETER_COUPONID_IS_NULL = "GTSF01";

    /**
     *提货凭证编号不能为空
     */
    public final static String TRANS_PARAMETER_VOUCHERID_IS_NULL = "GTSF02";

    /**
     *开发票申请信息编号不能为空
     */
    public final static String TRANS_PARAMETER_INVOICEINFOID_IS_NULL = "GTSF03";

    /**
     *音频信息有误
     */
    public final static String TRANS_AUDIO_ERROR = "GTSF04";

    /**
     *转发器接口提示信息(trans)--END
     */

}
