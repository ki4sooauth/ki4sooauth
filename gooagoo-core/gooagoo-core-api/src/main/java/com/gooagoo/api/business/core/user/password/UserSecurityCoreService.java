package com.gooagoo.api.business.core.user.password;

import java.util.List;

import com.gooagoo.entity.generator.user.UserSecurityCard;
import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.exception.business.user.AlreadyOverdueException;
import com.gooagoo.exception.business.user.EmailAlreadyActivedException;
import com.gooagoo.exception.business.user.MobileCodeAlreadyUsedException;
import com.gooagoo.exception.business.user.SecurityQuestionAnswerErrorException;

public interface UserSecurityCoreService
{

    /**
     * 设置密保问题
     * @param userId 用户编号
     * @param userPwdQuestionId 用户密保问题主键
     * @param sysPwdQuestionId 系统密保问题主键
     * @param question 问题内容
     * @param answer 问题答案
     * @return True/False
     * @throws Exception
     */
    public boolean setSecurityQuestion(String userId, String userPwdQuestionId, String sysPwdQuestionId, String question, String answer) throws Exception;

    /**
     * 删除密保问题
     * @param pwdQuestionNo 密保问题编号
     * @return True/False
     * @throws Exception
     */
    public boolean deleteSecurityQuestion(String pwdQuestionNo) throws Exception;

    /**
     * 绑定密保卡
     * @param userId 用户编号
     * @param serialNo 密保卡序列号
     * @param coordinateDate 坐标数据
     * @return True/False
     * @throws Exception
     */
    public boolean bindSecurityCard(String userId, String serialNo, String coordinateDate, String isBind) throws Exception;

    /**
     * 解除绑定的密保卡
     * @param userId 用户编号
     * @return True/False
     * @throws Exception
     */
    public boolean removeSecurityCard(String userId) throws Exception;

    /**
     * 查询用户已设置的密保问题
     * @param userId 用户编号
     * @return
     * @throws Exception
     */
    public List<UserSecurityQuestion> findUserSecurityQuestion(String userId) throws Exception;

    /**
     * 找回密保卡
     * @param account null/mobile手机号/userid用户名
     * @param code emailcode邮箱激活码/ mobilecode短信验证码/answer密保答案
     * @return UserSecurityCard用户密保卡信息
     * @throws MobileCodeAlreadyUsedException 手机验证码已使用异常
     * @throws AlreadyOverdueException 已过期异常
     * @throws SecurityQuestionAnswerErrorException 密保问题答案不正确异常
     * @throws EmailAlreadyActivedException 邮箱未激活异常
     */
    public UserSecurityCard recoverUserSecurityCard(String account, String code) throws Exception;

}
