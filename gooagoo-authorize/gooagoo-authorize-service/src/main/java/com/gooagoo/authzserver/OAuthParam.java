package com.gooagoo.authzserver;

/**
 * 授权参数
 */
public final class OAuthParam
{
    /**
     *授权类型，此值固定为“code” 
     */
    public static final String OAUTH_RESPONSE_TYPE = "response_type";
    /**
     * 申请gooagoo登录成功后，分配给网站的appid
     */
    public static final String OAUTH_CLIENT_ID = "client_id";
    /**
     * 申请gooagoo登录成功后，分配给网站的appkey 
     */
    public static final String OAUTH_CLIENT_SECRET = "client_secret";
    /**
     *成功授权后的回调地址，必须是注册appid时填写的主域名下的地址，建议设置为网站首页或网站的用户中心。
     *注意需要将url进行URLEncode 
     */
    public static final String OAUTH_REDIRECT_URI = "redirect_uri";
    /**
     * 可进行授权的列表。
     * 可填写的值是API文档中列出的接口，以及一些动作型的授权（目前仅有：do_like），如果要填写多个接口名称，请用逗号隔开
     * 例如：scope=get_user_info,list_album,upload_pic,do_like不传则默认请求对接口get_user_info进行授权。
     * 建议控制授权项的数量，只传入必要的接口名称，因为授权项越多，用户越可能拒绝进行任何授权。
     */
    public static final String OAUTH_SCOPE = "scope";
    /**
     * client端的状态值。用于第三方应用防止CSRF攻击
     */
    public static final String OAUTH_STATE = "state";
    /**
     * 授权类型，此值固定为“authorization_code”。
     */
    public static final String OAUTH_GRANT_TYPE = "grant_type";
    /**
     * 请求code 
     */
    public static final String OAUTH_CODE = "code";
    /**
     * 请求access token
     */
    public static final String OAUTH_AUTHORIZATION_CODE = "authorization_code";
    /**
     * authorization_code 有效期 ，单位为秒
     */
    public static final String OAUTH_CODE_EXPIRES_IN = "60";
    /**
     * 请求资源
     */
    public static final String OAUTH_ACCESS_TOKEN = "access_token";
    /**
     *access token 有效期 ，单位为天
     */
    public static final String OAUTH_TOKEN_EXPIRES_IN = "15";
    /**
     * 刷新token
     */
    public static final String OAUTH_REFRESH_TOKEN = "refresh_token";
    /**
     *当前授权用户的UID 
     */
    public static final String OAUTH_UID = "uid";
}
