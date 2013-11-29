package com.gooagoo.core.business.user.password;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.password.UserSecurityCoreService;
import com.gooagoo.api.generator.core.user.UserEmailactiveCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserMobileCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserSecurityCardGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserSecurityQuestionGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.entity.generator.user.UserSecurityCard;
import com.gooagoo.entity.generator.user.UserSecurityCardExample;
import com.gooagoo.entity.generator.user.UserSecurityCardExample.Criteria;
import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.entity.generator.user.UserSecurityQuestionExample;
import com.gooagoo.exception.business.user.AlreadyOverdueException;
import com.gooagoo.exception.business.user.EmailAlreadyActivedException;
import com.gooagoo.exception.business.user.MobileCodeAlreadyUsedException;
import com.gooagoo.exception.business.user.SecurityCardAlreadyBindException;
import com.gooagoo.exception.business.user.SecurityCardIsNotExistException;
import com.gooagoo.exception.business.user.SecurityQuestionAnswerErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class UserSecurityCoreServiceImpl implements UserSecurityCoreService
{

    @Autowired
    private UserSecurityQuestionGeneratorCoreService userSecurityQuestionGeneratorCoreService;
    @Autowired
    private UserSecurityCardGeneratorCoreService userSecurityCardGeneratorCoreService;
    @Autowired
    private UserMobileCodeGeneratorCoreService userMobileCodeGeneratorCoreService;
    @Autowired
    private UserInfoGeneratorCoreService userInfoGeneratorCoreService;
    @Autowired
    private UserEmailactiveCodeGeneratorCoreService userEmailactiveCodeGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean setSecurityQuestion(String userId, String userPwdQuestionId, String sysPwdQuestionId, String question, String answer) throws Exception
    {
        if (StringUtils.isNotBlank(userPwdQuestionId))
        {
            //更新用户密保问题
            UserSecurityQuestion userSecurityQuestion = this.userSecurityQuestionGeneratorCoreService.selectUnDelByPrimaryKey(userPwdQuestionId);
            if (userSecurityQuestion == null)
            {
                GooagooLog.info("用户密保问题不存在[id=" + userPwdQuestionId + "]");
                return false;
            }
            userSecurityQuestion.setSysId(sysPwdQuestionId);
            userSecurityQuestion.setContent(question);
            userSecurityQuestion.setAnswer(answer);
            UserSecurityQuestionExample userSecurityQuestionExample = new UserSecurityQuestionExample();
            userSecurityQuestionExample.createCriteria().andIdEqualTo(userPwdQuestionId);
            if (!this.userSecurityQuestionGeneratorCoreService.updateByExampleSelective(userSecurityQuestion, userSecurityQuestionExample))
            {
                GooagooLog.error("更新用户密保问题失败[UserSecurityQuestion=" + userSecurityQuestion.toString() + "]", null);
                throw new OperateFailException("更新用户密保问题失败[UserSecurityQuestion=" + userSecurityQuestion.toString() + "]");
            }
        }
        else
        {
            //清空所有用户密保问题后添加
            UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion();
            userSecurityQuestion.setIsDel("Y");
            UserSecurityQuestionExample userSecurityQuestionExample = new UserSecurityQuestionExample();
            userSecurityQuestionExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
            this.userSecurityQuestionGeneratorCoreService.updateByExampleSelective(userSecurityQuestion, userSecurityQuestionExample);
            userSecurityQuestion = new UserSecurityQuestion();
            userSecurityQuestion.setId(UUID.getUUID());
            userSecurityQuestion.setUserId(userId);
            if (StringUtils.isBlank(sysPwdQuestionId))
            {
                userSecurityQuestion.setType("2");
            }
            else
            {
                userSecurityQuestion.setType("1");
                userSecurityQuestion.setSysId(sysPwdQuestionId);
            }
            userSecurityQuestion.setContent(question);
            userSecurityQuestion.setAnswer(answer);
            userSecurityQuestion.setIsDel("N");
            if (!this.userSecurityQuestionGeneratorCoreService.insertSelective(userSecurityQuestion))
            {
                GooagooLog.error("添加用户密保问题失败[UserSecurityQuestion=" + userSecurityQuestion.toString() + "]", null);
                throw new OperateFailException("添加用户密保问题失败[UserSecurityQuestion=" + userSecurityQuestion.toString() + "]");
            }
        }
        return true;
    }

    @Override
    public boolean deleteSecurityQuestion(String pwdQuestionNo) throws Exception
    {
        UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion();
        userSecurityQuestion.setId(pwdQuestionNo);
        userSecurityQuestion.setIsDel("Y");
        return this.userSecurityQuestionGeneratorCoreService.updateByPrimaryKeySelective(userSecurityQuestion);
    }

    @Override
    public boolean bindSecurityCard(String userId, String serialNo, String coordinateDate, String isBind) throws Exception
    {
        UserSecurityCard userSecurityCard;
        if ("Y".equals(isBind))
        {
            UserSecurityCardExample userSecurityCardExample = new UserSecurityCardExample();
            userSecurityCardExample.createCriteria().andUserIdEqualTo(userId).andSerialNumEqualTo(serialNo).andIsDelEqualTo("N");
            List<UserSecurityCard> userSecurityCardList = this.userSecurityCardGeneratorCoreService.selectByExample(userSecurityCardExample);
            if (CollectionUtils.isEmpty(userSecurityCardList))
            {
                throw new SecurityCardIsNotExistException("密保卡不存在[serialNo=" + serialNo + ",userId=" + userId + "]");
            }
            userSecurityCard = userSecurityCardList.get(0);
            if ("Y".equals(userSecurityCard.getIsBind()))
            {
                throw new SecurityCardAlreadyBindException("密保卡已绑定[serialNo=" + serialNo + ",userId=" + userId + "]");
            }
            userSecurityCard.setIsBind("Y");
            return this.userSecurityCardGeneratorCoreService.updateByPrimaryKeySelective(userSecurityCard);
        }
        userSecurityCard = new UserSecurityCard();
        userSecurityCard.setId(UUID.getUUID());
        userSecurityCard.setUserId(userId);
        userSecurityCard.setSerialNum(serialNo);
        userSecurityCard.setCoordData(coordinateDate);
        userSecurityCard.setIsDel("N");
        userSecurityCard.setIsBind("N");
        return this.userSecurityCardGeneratorCoreService.insertSelective(userSecurityCard);
    }

    @Override
    public boolean removeSecurityCard(String userId) throws Exception
    {
        UserSecurityCard userSecurityCard = new UserSecurityCard();
        userSecurityCard.setIsBind("N");
        UserSecurityCardExample userSecurityCardExample = new UserSecurityCardExample();
        userSecurityCardExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
        this.userSecurityCardGeneratorCoreService.updateByExampleSelective(userSecurityCard, userSecurityCardExample);
        return true;
    }

    @Override
    public List<UserSecurityQuestion> findUserSecurityQuestion(String userId) throws Exception
    {
        UserSecurityQuestionExample userSecurityQuestionExample = new UserSecurityQuestionExample();
        userSecurityQuestionExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo("N");
        return this.userSecurityQuestionGeneratorCoreService.selectByExample(userSecurityQuestionExample);
    }

    @Override
    public UserSecurityCard recoverUserSecurityCard(String account, String code) throws Exception
    {
        Date currentTime = new Date();
        UserSecurityCardExample userSecurityCardExample = new UserSecurityCardExample();
        Criteria criteria = userSecurityCardExample.createCriteria();
        if (StringUtils.isNotBlank(account))
        {
            if (DataPatternUtils.checkMobilePhone(account))
            {//手机
                UserMobileCodeExample userMobileCodeExample = new UserMobileCodeExample();
                userMobileCodeExample.createCriteria().andMobileEqualTo(account).andCaptchaCodeEqualTo(code).andIsDelEqualTo("N");
                List<UserMobileCode> userMobileCodeList = this.userMobileCodeGeneratorCoreService.selectByExample(userMobileCodeExample);
                if (CollectionUtils.isEmpty(userMobileCodeList))
                {
                    GooagooLog.warn("查询手机验证码为空[mobile=" + account + "、captchacode=" + code + "]");
                    throw new NullException("查询手机验证码为空[mobile=" + account + "、captchacode=" + code + "]");
                }
                UserMobileCode userMobileCode = userMobileCodeList.get(0);
                if ("Y".equals(userMobileCode.getIsUsed()))
                {
                    GooagooLog.warn("手机验证码已使用[userMobileCode=" + userMobileCode.toString() + "]");
                    throw new MobileCodeAlreadyUsedException("手机验证码已使用[userMobileCode=" + userMobileCode.toString() + "]");
                }
                if (currentTime.after(userMobileCode.getExpDate()))
                {
                    GooagooLog.warn("手机验证码已过期[userMobileCode=" + userMobileCode.toString() + "]");
                    throw new AlreadyOverdueException("手机验证码已过期[userMobileCode=" + userMobileCode.toString() + "]");
                }
                UserInfoExample userInfoExample = new UserInfoExample();
                userInfoExample.createCriteria().andMobileEqualTo(account).andIsDelEqualTo("N");
                List<UserInfo> userInfoList = this.userInfoGeneratorCoreService.selectByExample(userInfoExample);
                if (CollectionUtils.isEmpty(userInfoList))
                {
                    GooagooLog.warn("查询个人用户表为空[mobile=" + account + "]");
                    throw new NullException("查询个人用户表为空[mobile=" + account + "]");
                }
                criteria.andUserIdEqualTo(userInfoList.get(0).getUserId());
            }
            else
            {//用户名
                UserSecurityQuestionExample userSecurityQuestionExample = new UserSecurityQuestionExample();
                userSecurityQuestionExample.createCriteria().andUserIdEqualTo(account).andIsDelEqualTo("N");
                List<UserSecurityQuestion> userSecurityQuestionList = this.userSecurityQuestionGeneratorCoreService.selectByExample(userSecurityQuestionExample);
                if (CollectionUtils.isEmpty(userSecurityQuestionList))
                {
                    GooagooLog.warn("查询用户密保问题表为空[userId=" + account + "]");
                    throw new NullException("查询用户密保问题表为空[userId=" + account + "]");
                }
                UserSecurityQuestion userSecurityQuestion = userSecurityQuestionList.get(0);
                if (!code.equals(userSecurityQuestion.getAnswer()))
                {
                    throw new SecurityQuestionAnswerErrorException("密保问题答案不正确[answer=" + userSecurityQuestion.getAnswer() + "、code=" + code + "]");
                }
                criteria.andUserIdEqualTo(account);
            }
        }
        else
        {//邮箱
            UserEmailactiveCode userEmailactiveCode = this.userEmailactiveCodeGeneratorCoreService.selectUnDelByPrimaryKey(code);
            if (userEmailactiveCode == null)
            {
                GooagooLog.warn("查询个人用户邮箱激活码为空[id=" + code + "]");
                throw new NullException("查询个人用户邮箱激活码为空[id=" + code + "]");
            }
            if ("Y".equals(userEmailactiveCode.getIsActive()))
            {
                GooagooLog.warn("邮箱已激活[userEmailactiveCode=" + userEmailactiveCode.toString() + "]");
                throw new EmailAlreadyActivedException("邮箱已激活[userEmailactiveCode=" + userEmailactiveCode.toString() + "]");
            }
            if (currentTime.after(userEmailactiveCode.getExpDate()))
            {
                GooagooLog.warn("邮箱激活码已过期[userEmailactiveCode=" + userEmailactiveCode.toString() + "]");
                throw new AlreadyOverdueException("邮箱激活码已过期[userEmailactiveCode=" + userEmailactiveCode.toString() + "]");
            }
            criteria.andUserIdEqualTo(userEmailactiveCode.getUserId());
            //状态改为已激活,防止重复使用
            userEmailactiveCode.setIsActive("Y");
            userEmailactiveCode.setActiveDate(new Date());
            if (!this.userEmailactiveCodeGeneratorCoreService.updateByPrimaryKeySelective(userEmailactiveCode))
            {
                GooagooLog.warn("激活邮箱失败[id=" + userEmailactiveCode.getId() + "]");
                throw new OperateFailException("激活邮箱失败[id=" + userEmailactiveCode.getId() + "]");
            }
        }
        criteria.andIsBindEqualTo("Y").andIsDelEqualTo("N");
        List<UserSecurityCard> userSecurityCardList = this.userSecurityCardGeneratorCoreService.selectByExample(userSecurityCardExample);
        if (CollectionUtils.isNotEmpty(userSecurityCardList))
        {
            return userSecurityCardList.get(0);
        }
        return null;
    }
}
