package com.gooagoo.core.business.user.manage;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.manage.UserPasswordCoreService;
import com.gooagoo.api.business.core.user.password.UserSecurityCoreService;
import com.gooagoo.api.generator.core.user.UserEmailactiveCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserMobileCodeGeneratorCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.casclient.personal.PersonalInfo;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.exception.business.user.SecurityQuestionAnswerErrorException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.exception.common.PasswordIncorrectException;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisObjectDao;

@Service
public class UserPasswordCoreServiceImpl implements UserPasswordCoreService

{

    @Autowired
    private UserInfoGeneratorCoreService userInfoGeneratorCoreService;
    @Autowired
    private UserEmailactiveCodeGeneratorCoreService userEmailactiveCodeGeneratorCoreService;
    @Autowired
    private UserMobileCodeGeneratorCoreService userMobileCodeGeneratorCoreService;
    @Autowired
    private UserProtectedCoreService userProtectedCoreService;
    @Autowired
    private UserSecurityCoreService userSecurityCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean resetPassword(String account, String password, String activeCode) throws Exception
    {
        Date currentTime = new Date();
        UserInfo userInfo = null;
        //1、数据校验
        this.checkResetPasswordData(account, password, activeCode);
        //2、处理重置密码
        if (StringUtils.isNotBlank(account))
        {
            if (DataPatternUtils.checkMobilePhone(account))
            {//手机重置密码
                userInfo = this.resetPasswordByMobile(account, password, activeCode, currentTime);
            }
            else
            {//账号密保问题重置密码
                userInfo = this.resetPasswordByAccount(account, password, activeCode, currentTime);
            }
        }
        else
        {
            userInfo = this.resetPasswordByEmail(password, activeCode, currentTime);
        }
        if (userInfo == null)
        {
            return false;
        }
        //更新redis信息
        this.updateRedis2Password(userInfo, null);
        return true;
    }

    @Override
    public boolean updatePassword(String userLoginRedisKey, String userId, String oldPassword, String newPassword) throws Exception
    {
        //1、数据校验
        this.checkUpdatePasswordData(userId, oldPassword, newPassword);
        //2、处理修改密码
        UserInfo userInfo = this.userProtectedCoreService.getNormalUserInfo(userId);
        if (userInfo == null)
        {
            GooagooLog.info("修改密码：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        if (!userInfo.getPassword().equals(new Md5Utils().encrypt(oldPassword)))
        {
            GooagooLog.info("修改密码：用户（" + userId + "）原密码（" + oldPassword + "）不正确");
            throw new PasswordIncorrectException("用户（" + userId + "）原密码（" + oldPassword + "）不正确");
        }
        userInfo.setPassword(new Md5Utils().encrypt(newPassword));
        if (!this.userInfoGeneratorCoreService.updateByPrimaryKeySelective(userInfo))
        {
            GooagooLog.error("修改密码：更新密码（" + userInfo.toString() + "）异常", null);
            throw new OperateFailException("更新密码（" + userInfo.toString() + "）异常");
        }
        //更新redis信息
        this.updateRedis2Password(userInfo, userLoginRedisKey);
        return true;
    }

    /**
     * 校验重置密码数据
     * @param account
     * @param password
     * @param activeCode
     * @return
     * @throws FormatErrorException
     * @throws NullException
     */
    private boolean checkResetPasswordData(String account, String password, String activeCode) throws Exception
    {
        //1、校验密码
        if (StringUtils.isBlank(password))
        {
            GooagooLog.info("校验重置密码数据：新密码（" + password + "）为空");
            throw new NullException("新密码（" + password + "）为空");
        }
        if (password.length() < 6 || password.length() > 20)
        {
            GooagooLog.info("校验重置密码数据：新密码（" + password + "）长度只能在6-20位字符之间");
            throw new FormatErrorException("新密码（" + password + "）长度只能在6-20位字符之间");
        }
        //2、校验激活码
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("校验重置密码数据：校验码（" + activeCode + "）为空");
            throw new NullException("校验码（" + activeCode + "）为空");
        }

        return true;
    }

    /**
     * 通过手机号码重置密码
     * @param account
     * @param password
     * @param activeCode
     * @param currentTime
     * @return
     * @throws FormatErrorException
     * @throws NullException
     * @throws OperateFailException
     */
    private UserInfo resetPasswordByMobile(String account, String password, String activeCode, Date currentTime) throws FormatErrorException, NullException, OperateFailException
    {
        UserInfoExample queryCondition1 = new UserInfoExample();
        queryCondition1.createCriteria().andMobileEqualTo(account).andUserStatusEqualTo("U").andIsActiveEmailEqualTo("Y").andIsDelEqualTo("N");
        List<UserInfo> userInfoList = this.userInfoGeneratorCoreService.selectByExample(queryCondition1);
        if (CollectionUtils.isEmpty(userInfoList))
        {
            GooagooLog.info("通过手机号码重置密码：用户（" + account + "）状态异常");
            throw new OperateFailException("用户（" + account + "）状态异常");
        }
        UserInfo userInfo = userInfoList.get(0);
        userInfo.setPassword(new Md5Utils().encrypt(password));
        UserMobileCodeExample queryCondition = new UserMobileCodeExample();
        queryCondition.createCriteria().andMobileEqualTo(account).andCaptchaCodeEqualTo(activeCode).andIsUsedEqualTo("Y").andIsDelEqualTo("N");
        Integer count = this.userMobileCodeGeneratorCoreService.countByExample(queryCondition);
        if (count == null || count == 0)
        {
            GooagooLog.info("通过手机号码重置密码：手机（" + account + "）验证码（" + activeCode + "）不正确");
            throw new OperateFailException("手机（" + account + "）验证码（" + activeCode + "）不正确");
        }
        if (!this.userInfoGeneratorCoreService.updateByPrimaryKeySelective(userInfo))
        {
            GooagooLog.error("通过手机号码重置密码：更新用户信息（" + userInfo.toString() + "）异常", null);
            throw new OperateFailException("更新用户信息（" + userInfo.toString() + "）异常");
        }
        return userInfo;
    }

    /**
     * 通过账号密保重置密码
     * @param userId 账号
     * @param password 密码
     * @param answer 密保答案
     * @param currentTime
     * @return
     * @throws FormatErrorException
     * @throws NullException
     * @throws OperateFailException
     */
    private UserInfo resetPasswordByAccount(String account, String password, String answer, Date currentTime) throws Exception
    {
        List<UserSecurityQuestion> UserSecurityQuestionList = this.userSecurityCoreService.findUserSecurityQuestion(account);
        if (CollectionUtils.isEmpty(UserSecurityQuestionList))
        {
            GooagooLog.info("用户还未设定密保问题[account=" + account + "]");
            return null;
        }
        if (!answer.equals(UserSecurityQuestionList.get(0).getAnswer()))
        {
            GooagooLog.info("通过账号密保问题重置密码：密保问题答案与设置答案不一致[账号=" + account + "、密保问题=" + answer + "]不正确");
            throw new SecurityQuestionAnswerErrorException("账号（" + account + "）密保问题（" + answer + "）不正确");
        }
        UserInfo userInfo = this.userInfoGeneratorCoreService.selectByPrimaryKey(account);
        if (userInfo == null)
        {
            GooagooLog.info("通过账号密保问题重置密码：用户（" + account + "）状态异常");
            throw new OperateFailException("通过账号密保问题重置密码：用户（" + account + "）状态异常");
        }
        userInfo.setPassword(new Md5Utils().encrypt(password));
        if (!this.userInfoGeneratorCoreService.updateByPrimaryKeySelective(userInfo))
        {
            GooagooLog.error("通过账号密保问题重置密码：更新用户信息（" + userInfo.toString() + "）异常", null);
            throw new OperateFailException("更新用户信息（" + userInfo.toString() + "）异常");
        }
        return userInfo;
    }

    /**
     * 通过电子邮箱重置密码
     * @param password
     * @param activeCode
     * @param currentTime
     * @return
     * @throws FormatErrorException
     * @throws NullException
     * @throws OperateFailException
     */
    private UserInfo resetPasswordByEmail(String password, String activeCode, Date currentTime) throws FormatErrorException, NullException, OperateFailException
    {
        UserEmailactiveCode userEmailactiveCode = this.userEmailactiveCodeGeneratorCoreService.selectByPrimaryKey(activeCode);
        if (userEmailactiveCode == null || "Y".equals(userEmailactiveCode.getIsDel()))
        {
            GooagooLog.info("通过电子邮箱重置密码：邮箱激活码（" + activeCode + "）不存在");
            throw new OperateFailException("邮箱激活码（" + activeCode + "）不存在");
        }
        if ("Y".equals(userEmailactiveCode.getIsActive()) || currentTime.after(userEmailactiveCode.getExpDate()))
        {
            GooagooLog.info("通过电子邮箱重置密码：邮箱激活码（" + activeCode + "）已失效");
            throw new OperateFailException("邮箱激活码（" + activeCode + "）已失效");
        }
        userEmailactiveCode.setIsActive("Y");
        userEmailactiveCode.setActiveDate(currentTime);
        if (!this.userEmailactiveCodeGeneratorCoreService.updateByPrimaryKeySelective(userEmailactiveCode))
        {
            GooagooLog.error("通过电子邮箱重置密码：更新邮箱激活码信息（" + userEmailactiveCode.toString() + "）异常", null);
            throw new OperateFailException("更新邮箱激活码信息（" + userEmailactiveCode.toString() + "）异常");
        }
        UserInfo userInfo = this.userProtectedCoreService.getNormalUserInfo(userEmailactiveCode.getUserId());
        if (userInfo == null)
        {
            GooagooLog.info("通过电子邮箱重置密码：用户（" + userEmailactiveCode.getUserId() + "）状态异常");
            throw new OperateFailException("用户（" + userEmailactiveCode.getUserId() + "）状态异常");
        }
        userInfo.setPassword(new Md5Utils().encrypt(password));
        if (!this.userInfoGeneratorCoreService.updateByPrimaryKeySelective(userInfo))
        {
            GooagooLog.error("通过电子邮箱重置密码：更新用户信息（" + userInfo.toString() + "）异常", null);
            throw new OperateFailException("更新用户信息（" + userInfo.toString() + "）异常");
        }

        return userInfo;
    }

    /**
     * 校验修改密码数据
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     * @throws FormatErrorException
     * @throws NullException
     */
    private boolean checkUpdatePasswordData(String userId, String oldPassword, String newPassword) throws FormatErrorException, NullException
    {
        //1、校验用户编号
        if (StringUtils.isBlank(userId))
        {
            GooagooLog.info("校验修改密码数据：用户编号（" + userId + "）为空");
            throw new NullException("用户编号（" + userId + "）为空");
        }
        //2、校验原密码
        if (StringUtils.isBlank(oldPassword))
        {
            GooagooLog.info("校验修改密码数据：原密码（" + oldPassword + "）为空");
            throw new NullException("原密码（" + oldPassword + "）为空");
        }
        //3、校验新密码
        if (StringUtils.isBlank(newPassword))
        {
            GooagooLog.info("校验修改密码数据：新密码（" + newPassword + "）为空");
            throw new NullException("新密码（" + newPassword + "）为空");
        }
        if (newPassword.length() < 6 || newPassword.length() > 20)
        {
            GooagooLog.info("校验修改密码数据：新密码（" + newPassword + "）长度只能在6-20个字符之间");
            throw new FormatErrorException("新密码（" + newPassword + "）长度只能在6-20个字符之间");
        }

        return true;
    }

    /**
     * 更新redis中的密码
     * @param userInfo
     * @param userLoginRedisKey
     */
    private void updateRedis2Password(UserInfo userInfo, String userLoginRedisKey)
    {
        RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);
        redisHashDao.put(userInfo.getUserId(), "password", userInfo.getPassword());
        if (StringUtils.isNotBlank(userLoginRedisKey))
        {
            RedisObjectDao redisObjectDao = new RedisObjectDao(RedisServerConstants.login_gus);
            PersonalLoginInfo personalLoginInfo = redisObjectDao.getGenerics(userLoginRedisKey, PersonalLoginInfo.class);
            if (personalLoginInfo != null)
            {
                PersonalInfo personalInfo = personalLoginInfo.getPersonalInfo();
                if (personalInfo != null)
                {
                    personalInfo.setPassword(userInfo.getPassword());
                    redisObjectDao.set(userLoginRedisKey, personalLoginInfo);
                }
            }
        }
    }

}
