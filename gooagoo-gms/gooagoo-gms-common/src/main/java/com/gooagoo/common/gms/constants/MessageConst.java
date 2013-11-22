package com.gooagoo.common.gms.constants;

public final class MessageConst
{
    /**
     *  操作成功
     */
    public final static String GMS_OPERATE_SUCCESS = "GMSA01";

    /**
     *  操作失败
     */
    public final static String GMS_OPERATE_FAIL = "GMSA02";

    /**
     *  没有符合条件的信息
     */
    public final static String GMS_SEARCH_NO_DATA = "GMSA03";

    /**
     *  上传图片失败
     */
    public final static String FILE_UPLOAD_PIC_FAIL = "GMSB01";

    /**
     *  上传文件格式不符合要求
     */
    public final static String FILE_UPLOAD_PIC_FORMATTER_ERROR = "GMSB02";

    /**
     *  上传文件时保存文件失败
     */
    public final static String FILE_UPLOAD_SAVE_FAIL = "GMSB03";

    /**
     *  所使用优惠凭证不是本人的优惠凭证,请选择本人的优惠凭证
     */
    public final static String GMS_MARKETING_COUPON_NOT_USER_OWN = "GMSC01";

    /**
     *  优惠凭证的已锁定，不能使用
     */
    public final static String GMS_MARKETING_COUPON_ALREADY_LOCK = "GMSC02";

    /**
     *  优惠凭证已经使用,不能重复使用
     */
    public final static String GMS_MARKETING_COUPON_ALREADY_USE = "GMSC03";

    /**
     *  优惠凭证已过期
     */
    public final static String GMS_MARKETING_COUPON_OUT_OF_USE_TIME = "GMSC04";

    /**
     *  优惠凭证只能在规定品类范围内使用
     */
    public final static String GMS_MARKETING_COUPON_OUT_OF_USE_CATEGORY = "GMSC05";

    /**
     *  优惠凭证只能在规定实体店范围内使用
     */
    public final static String GMS_MARKETING_COUPON_OUT_OF_USE_SHOPENTITYID = "GMSC06";

    /**
     *  优惠凭证已被发布不能进行修改操作
     */
    public final static String GMS_MARKETING_COUPON_UNUPD_RELEASE_COUPON = "GMSC07";

    /**
     *  发布人群数量小于1不能发布
     */
    public final static String GMS_MARKETING_EVENT_UNRELEASE_PEOPLE_NUM_LESS_1 = "GMSD01";

    /**
     *  会员卡名称不能重复
     */
    public final static String GMS_MEMBER_CARD_NAME_EXIST_SO_CAN_NOT＿CREATE = "GMSE01";

    /**
     *  用户名已存在
     */
    public final static String GMS_SHOPINFO_BASE_ALREADY_EXIST_USERNAME = "GMSF01";

    /**
     *  原密码输入错误
     */
    public final static String GMS_SHOPINFO_BASE_ORGPASSWORD_FAIL = "GMSF02";

    /**
     *  桌号已存在
     */
    public final static String GMS_SHOPINFO_DESK_ALREADY_EXIST = "GMSF03";

    /**
     *  非高级卡只能创建一个
     */
    public final static String GMS_MEMBER_CARD_NOTSENIOR_CREATE_ONE = "GMSG01";

    /**
     *  会员卡已发放到用户
     */
    public final static String GMS_MEMBER_CARD_ALREADY_GIVE_OUT = "GMSG02";

    /**
     *  还没有创建关注卡，不能创建基础卡
     */
    public final static String GMS_MEMBER_CARD_BASECRAD_SHOULD_CREATE_BEFORE_ATTENTIONCARD = "GMSG03";

    /**
     *  还没有创建基础卡，不能创建高级卡
     */
    public final static String GMS_MEMBER_CARD_BASECRAD_SHOULD_CREATE_BEFORE_TOPCARD = "GMSG04";

    /**
     *  存在高级卡，无法删除基本卡
     */
    public final static String GMS_MEMBER_CARD_UNABLE_DEL_BASECARD_BECAUSE_ALREADY_EXIST_TOPCARD = "GMSG05";

    /**
     *  存在基本卡，无法删除关注卡
     */
    public final static String GMS_MEMBER_CARD_UN_DEL_ATTENTIONCARD_BECAUSE_ALREADY_EXIST_BASECARD = "GMSG06";

    /**
     *  卡类型已用完
     */
    public final static String GMS_MEMBER_CARD_TYPE_NOT_ENOUGH = "GMSG07";

    /**
     *  生成卡号异常
     */
    public final static String GMS_MEMBER_CARD_CREATE_EXCEPTION_CARDNO = "GMSG08";

    /**
     *  卡号错误
     */
    public final static String GMS_MEMBER_CARD_CARDNO_ERROR = "GMSG09";

    /**
     *  此卡已被转换
     */
    public final static String GMS_MEMBER_CARD_ISSWITCH = "GMSG10";

    /**
     *  用户已有此卡
     */
    public final static String GMS_MEMBER_CARD_ALREADY_HAVE_THIS_CARD = "GMSG11";

    /**
     *  用户没有此卡
     */
    public final static String GMS_MEMBER_CARD_USER_DONOT_HAVE_THIS_CARD = "GMSG12";

    /**
     *  用户已有商家的卡
     */
    public final static String GMS_MEMBER_CARD_USER_ALREADY_HAVE_CARD_OF_SHOP = "GMSG13";

    /**
     *  商家无此卡
     */
    public final static String GMS_MEMBER_CARD_SHOP_DONOT_HAVE_THIS_CARD = "GMSG14";

    /**
     *  商家无此会员
     */
    public final static String GMS_MEMBER_CARD_SHOP_DONOT_HAVE_THIS_MEMBER = "GMSG15";

    /**
     *  会员卡不存在或已删除
     */
    public final static String GMS_MEMBER_CARD_NOT_EXIST_OR_DEL = "GMSG16";

    /**
     *  发卡失败
     */
    public final static String GMS_MEMBER_CARD_GIVECARD_FAIL = "GMSG17";

    /**
     * 会员特征编码己存在
     */
    public static final String GMS_MEMBER_FEATURE_CODE_ALREADY_EXIST = "GMSG18";

    /**
     * 竞拍活动不存在或己删除
     */
    public static final String GMS_SHOPAD_DELETED_OR_NOT_EXIST = "GMSH01";

    /**
     * 竞拍时间未到或已结束
     */
    public static final String GMS_SHOPBID_TIME_INVALID = "GMSH02";

    /**
     * 竞拍出价小余或等于最高金额
     */
    public static final String GMS_SHOPBID_AMOUNT_LACK = "GMSH03";
    /**
     *  关注卡己存在
     */
    public final static String GMS_MEMBER_ATTENTION_CARD_ALREADY_EXIST = "GMSG19";

    /**
     *  基本卡己存在
     */
    public final static String GMS_MEMBER_BASE_CARD_ALREADY_EXIST = "GMSG20";

    /**
     * 会员卡已发放，禁止操作
     */
    public static final String GMS_MEMBER_CARD_ALREADY_GIVEN_USER_NOT_UPDATE = "GMSG21";

    /**
     *  模板数据不能为空
     */
    public final static String GMS_TEMPLATEDATA_CAN_NOT_BE_EMPTY = "GMSI01";

    /**
     * 只能有一个主店
     */
    public static final String GMS_SHOPINFO_NOT_UNIQUE_GENERAL_ENTITY = "GMSF05";
    /**
     * 实体店名称已存在 
     */
    public static final String GMS_SHOPINFO_ENTITYNAME_ALREADY_EXIST = "GMSF04";

    /**
     * 非连锁店只能创建一家实体店
     */
    public static final String GMS_SHOPINFO_NOT_CHAIN_SHOP_ONLY_HAVE_ONE_ENTITY = "GMSF06";
    /**
     * 您已创建多家实体店，不能修改是否连锁值为否
     */
    public static final String GMS_SHOPINFO_HAVE_MANY_ENTITY_CANNOT_UPDATE_IS_CHAIN_AS_N = "GMSF07";

    /**
     *  误差过大
     */
    public final static String GMS_AREAPARA_ACTUALMAP_AND_SVG_PER_ERROR_IS_TOO_LARGE = "GMSJ01";

    /**
    *  仍有网格未被编辑
    */
    public final static String GMS_GRID_DATA_NOT_ENOUGH = "GMSJ02";

    /**
     *  网格区有重叠
     */
    public final static String GMS_GRID_DATA_OVERLAY = "GMSJ03";
}
