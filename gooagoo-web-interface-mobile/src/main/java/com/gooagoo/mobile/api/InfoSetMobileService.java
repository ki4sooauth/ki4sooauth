package com.gooagoo.mobile.api;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.mobile.entity.mobf01.transform.MemberLoginRoot;
import com.gooagoo.mobile.entity.mobf06.transform.UserInfoRoot;
import com.gooagoo.mobile.entity.mobf11.transform.UpdateAppInfoRoot;

/**
 * 设置相关接口
 * 如果接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface InfoSetMobileService
{
    /**
     *  接口 mobf01 : 用户登陆 
     * @param account 登录账号
     * @param password 密码
     * @param mac 手机mac地址
     * @param mver 手机程序版本
     * @param iphonetoken Iphone的token值
     * @return
     * @throws Exception
     */
    public MemberLoginRoot userLogin(String account, String password, String mac, String mver, String iphonetoken) throws Exception;

    /**
     * 接口 mobf02 : 用户忘记口令
     * @param email 用户邮箱
     * @return
     * @throws Exception
     */
    public boolean userForgetPassword(String email) throws Exception;

    /**
     * 接口 mobf03 : 用户注册(邮箱) 
     * @param email 用户邮箱
     * @param password 密码
     * @param mac 手机mac地址
     * @param mver 手机程序版本
     * @param regIp 注册ip地址
     * @return
     * @throws Exception
     */
    public boolean userRegister(String email, String password, String mac, String mver, String regIp) throws Exception;

    /**
     * 接口 mobf04 : 用户口令更改
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param oldPassword 旧密码
     * @param newPassword 信息密码
     * @return
     * @throws Exception
     */
    public boolean changePassword(String userId, String sessionId, String oldPassword, String newPassword) throws Exception;

    /**
     * 接口 mobf05 : 用户更改基本信息 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param request 接口入参集合（包含用户需要更改的基本信息）
     * @return
     * @throws Exception
     */
    public boolean userChangeBaseInfo(String userId, String sessionId, HttpServletRequest request) throws Exception;

    /**
     * 接口 mobf06 : 用户获取基本信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @return
     * @throws Exception
     */
    public UserInfoRoot getUserInfo(String userId, String sessionId) throws Exception;

    /**
     * 接口 mobf07 : 意见反馈 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param content 意见反馈内容
     * @param mac 手机mac地址
     * @param mVer 手机程序版本
     * @param mType 当前手机型号
     * @param ip 评论者所在ip
     * @param hostName 评论者主机名
     * @return
     * @throws Exception
     */
    public boolean feedback(String userId, String sessionId, String content, String mac, String mVer, String mType, String ip, String hostName) throws Exception;

    /**
     * 接口 mobf08 : 获取gooagooid 
     * @param mac 手机mac地址
     * @param mId 手机硬件id
     * @param mVer 手机程序版本
     * @param mType 手机系统类型
     * @return
     * @throws Exception
     */
    public String getGooagooId(String mac, String mId, String mVer, String mType) throws Exception;

    /**
     * 接口 mobf09 : 用户注册(手机号-获取短信验证码)
     * @param phone 手机号码
     * @return
     * @throws Exception
     */
    public String getPhoneVerifycode(String phone) throws Exception;

    /**
     * 接口 mobf10 : 用户注册(手机号-输入短信验证码)
     * @param phone 手机号码
     * @param password 密码
     * @param verifycode 验证码
     * @param mac 手机mac地址
     * @param mver 手机程序版本
     * @param regIp 注册ip地址
     * @return
     * @throws Exception
     */
    public boolean checkVerifycode(String phone, String password, String verifycode, String mac, String mver, String regIp) throws Exception;

    /**
     * mobf11:检查更新gooagoo APP最新版本 
     * @param appcode APP识别码
     * @param version 程序版本
     * @param mobileType 系统类型
     * @return
     * @throws Exception
     */
    public UpdateAppInfoRoot getUpdateAppInfo(String appcode, String version, String mobileType) throws Exception;
}
