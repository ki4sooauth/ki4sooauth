package com.gooagoo.icms.common.util;

public class Constants
{
    /**************登录注册开始**************/

    /**
     * 用户
     */
    public final static String CAS_FILTER_USER = "user";

    /**
     * 用户ID
     */
    public final static String CAS_FILTER_USER_USERID = "com.gooagoo.passpart.sso.user.userid";

    /**
     * 用户TOKEN
     */
    public final static String CAS_FILTER_USER_TOKEN = "com.gooagoo.passpart.sso.user.token";

    /**
     * 用户邮箱
     */
    public final static String CAS_USER_EMAIL = "comgooagoocompassportssouseremail";

    /**
     * 用户昵称
     */
    public final static String CAS_USER_NICKNAME = "comgooagoocompassportssousernickname";

    /**
     * 用户头像（大图）
     */
    public final static String CAS_USER_HEADPIC_BIG = "comgooagoocompassportssouserheadpicbig";

    /**
     * 商家
     */
    public final static String CAS_FILTER_SHOP = "com.gooagoo.passpart.sso.shop";

    /**
     * 商家登录类型(S商家 A普通管理员)
     */
    public final static String CAS_FILTER_SHOPT = "com.gooagoo.passpart.sso.type";

    /**
     * 商家登录实体
     */
    public final static String CAS_FILTER_SHOPI = "shopVo";

    /**************登录注册结束**************/

    /**************个人中心开始**************/
    /**
     * 手机虚拟商家基址
     */
    public final static String GUS_MOBILE_BASE_URL = "mobile_base_url";

    /**
     * 网站虚拟商家基址
     */
    public final static String GUS_WEB_BASE_URL = "web_base_url";

    /**************个人中心结束**************/

    /**
     * 接口流水号参数名
     */
    public final static String INTERFACE_SERIAL = "com.gooagoo.interface.serial";

    /**
     * 接口编码常量
     */
    public final static String INTERFACE_CODE = "com.gooagoo.interface.code";

    /**
     * interface接口对象名(spring注入的名称)
     */
    public final static String INTERFACE_OBJ = "CType";

    /**
     * 具体接口调用的方法名
     */
    public final static String INTERFACE_MET = "MType";

    /**
     * 位置顶级编码
     */
    public final static String POSITION_TOP_LEVEL = "-1";
    /**
     * 权限顶级编码
     */
    public final static String AUTH_TOP_LEVEL = "-1";

    /**
     * 运营平台管理系统
     */
    /**
     * 登录用户权限
     */
    public final static String MIS_LOGIN_AUTHS = "MIS_LOGIN_AUTHS";

    /**
     * 登录用户Id
     */
    public final static String MIS_LOGIN_ID = "MIS_LOGIN_ID";
}
