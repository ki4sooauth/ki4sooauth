package com.gooagoo.api.business.query.user.password;

import java.util.List;

import com.gooagoo.entity.generator.user.SysSecurityQuestion;
import com.gooagoo.entity.generator.user.UserSecurityQuestion;

/**
 * 用户密保
 */
public interface UserSecurityQueryService
{

    /**
     * 查询系统内置密保问题
     * @return
     * @throws Exception
     */
    public List<SysSecurityQuestion> findSysSecurityQuestion() throws Exception;

    /**
     * 查询用户已设置的密保问题
     * @param userId 用户编号
     * @return
     * @throws Exception
     */
    public List<UserSecurityQuestion> findUserSecurityQuestion(String userId) throws Exception;

    /**
     * 查询用户已绑定的密保卡
     * @param userId 用户编号
     * @return 序列号
     * @throws Exception
     */
    public String findUserBindedSecurityCard(String userId) throws Exception;

    /**
     * 设置登录密保卡坐标
     * @param coordinate 坐标
     * @param expireSecond 有效时间(单位:秒)
     * @return token
     * @throws Exception
     */
    public String setLoginSecurityCardCoordinate(String coordinate, Integer expireSecond) throws Exception;

    /**
     * 验证登录密保卡坐标数据
     * @param token token值
     * @param account 账号
     * @param coordinatedate 坐标数据
     * @return True/False
     * @throws Exception
     */
    public boolean checkLoginSecurityCardCoordinateDate(String token, String account, String coordinatedate) throws Exception;

}
