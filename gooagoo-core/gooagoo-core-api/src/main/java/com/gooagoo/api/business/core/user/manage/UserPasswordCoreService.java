package com.gooagoo.api.business.core.user.manage;

import com.gooagoo.exception.business.user.SecurityQuestionAnswerErrorException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.exception.common.PasswordIncorrectException;

public interface UserPasswordCoreService

{
    /**
     * 重置密码
     * @param account 用户账户（phone/email/userId）
     * @param password 密码
     * @param activeCode 激活码/密保答案
     * @return true/false
     * @throws SecurityQuestionAnswerErrorException 密保问题答案不正确异常
     * @throws FormatErrorException
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean resetPassword(String account, String password, String activeCode) throws Exception;

    /**
     * 修改密码
     * @param userLoginRedisKey redis存储个人登录信息key
     * @param userId 用户主键
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @return true/f
     * @throws PasswordIncorrectException
     * @throws OperateFailException
     * @throws FormatErrorException
     * @throws NullException
     */
    public boolean updatePassword(String userLoginRedisKey, String userId, String oldPassword, String newPassword) throws Exception;

}
