package com.gooagoo.core.business.user.manage;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.user.manage.UserActiveCodeCoreService;
import com.gooagoo.api.generator.core.user.UserEmailactiveCodeGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.user.UserMobileCodeGeneratorCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataPatternUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.exception.common.AccountAlreadyExistsException;
import com.gooagoo.exception.common.AccountIsLockedException;
import com.gooagoo.exception.common.AccountNotActiveException;
import com.gooagoo.exception.common.AccountNotExistException;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.gooagoo.redis.data.RedisStringDao;

@Service
public class UserActiveCodeCoreServiceImpl implements UserActiveCodeCoreService
{

    @Autowired
    private UserInfoGeneratorCoreService userInfoGeneratorCoreService;

    @Autowired
    private UserEmailactiveCodeGeneratorCoreService userEmailactiveCodeGeneratorCoreService;

    @Autowired
    private UserMobileCodeGeneratorCoreService userMobileCodeGeneratorCoreService;

    @Autowired
    private UserProtectedCoreService userProtectedCoreService;

    @Override
    public String getEmailActiveCode(String email) throws Exception
    {
        Date currentTime = new Date();
        //1、验证邮箱地址
        this.checkEmail(email);
        //2、获取用户信息
        UserInfoExample queryCondition = new UserInfoExample();
        queryCondition.createCriteria().andEmailEqualTo(email).andIsDelEqualTo("N");
        List<UserInfo> userInfoList = this.userInfoGeneratorCoreService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(userInfoList))
        {
            GooagooLog.info("获取邮箱激活码：账号（" + email + "）不存在");
            throw new AccountNotExistException("账号（" + email + "）不存在");
        }
        UserInfo userInfo = userInfoList.get(0);
        if ("N".equals(userInfo.getIsActiveEmail()))
        {
            GooagooLog.info("获取邮箱激活码：账号（" + email + "）未激活");
            throw new AccountNotActiveException("账号（" + email + "）未激活");
        }
        if ("L".equals(userInfo.getUserStatus()))
        {
            GooagooLog.info("获取邮箱激活码：账号（" + email + "）已被锁定");
            throw new AccountIsLockedException("账号（" + email + "）已被锁定");
        }
        //3、组装邮箱激活码信息
        UserEmailactiveCode userEmailactiveCode = this.getUserEmailactiveCode(userInfo.getUserId(), currentTime);
        //4、保存邮箱激活码信息
        if (!this.userEmailactiveCodeGeneratorCoreService.insertSelective(userEmailactiveCode))
        {
            GooagooLog.error("获取邮箱激活码：保存邮箱激活码信息（" + userEmailactiveCode.toString() + "）异常", null);
            throw new OperateFailException("保存邮箱激活码信息（" + userEmailactiveCode.toString() + "）异常");
        }

        return userEmailactiveCode.getId();
    }

    @Override
    public String getEmailActiveCodeForBindMobile(String userId, String email, String mobile) throws Exception
    {
        Date currentTime = new Date();
        //1、验证邮箱地址
        this.checkEmail(email);
        //2、验证手机号码
        this.checkMobile(mobile);
        UserInfoExample queryCondition = new UserInfoExample();
        queryCondition.createCriteria().andMobileEqualTo(mobile);
        Integer count = this.userInfoGeneratorCoreService.countByExample(queryCondition);
        if (count == null || count != 0)
        {
            GooagooLog.info("获取邮箱激活码 ：手机号码（" + mobile + "）已存在");
            throw new AccountAlreadyExistsException("手机号码（" + mobile + "）已存在");
        }
        //3、验证用户
        UserInfo userInfo = this.userProtectedCoreService.getNormalUserInfo(userId);
        if (userInfo == null)
        {
            GooagooLog.info("获取邮箱激活码 ：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        if (!email.equals(userInfo.getEmail()))
        {
            GooagooLog.info("获取邮箱激活码 ：用户（" + userId + "）邮箱地址（" + userInfo.getEmail() + "）不正确（" + email + "）");
            throw new OperateFailException("用户（" + userId + "）邮箱地址（" + userInfo.getEmail() + "）不正确（" + email + "）");
        }
        //4、组装邮箱激活码信息
        UserEmailactiveCode userEmailactiveCode = this.getUserEmailactiveCode(userInfo.getUserId(), currentTime);
        //5、保存邮箱激活码信息
        if (!this.userEmailactiveCodeGeneratorCoreService.insertSelective(userEmailactiveCode))
        {
            GooagooLog.error("获取邮箱激活码：保存邮箱激活码信息（" + userEmailactiveCode.toString() + "）异常", null);
            throw new OperateFailException("保存邮箱激活码信息（" + userEmailactiveCode.toString() + "）异常");
        }

        return userEmailactiveCode.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String getEmailActiveCodeForBindEmail(String userId, String email, String mobileActiveCode) throws Exception
    {
        Date currentTime = new Date();
        //1、验证邮箱地址
        this.checkEmail(email);
        UserInfoExample queryCondition1 = new UserInfoExample();
        queryCondition1.createCriteria().andEmailEqualTo(email);
        Integer count = this.userInfoGeneratorCoreService.countByExample(queryCondition1);
        if (count == null || count != 0)
        {
            GooagooLog.info("获取邮箱激活码 ：邮箱地址（" + email + "）已存在");
            throw new OperateFailException("邮箱地址（" + email + "）已存在");
        }
        //2、验证用户
        UserInfo userInfo = this.userProtectedCoreService.getNormalUserInfo(userId);
        if (userInfo == null)
        {
            GooagooLog.info("获取邮箱激活码 ：用户（" + userId + "）状态异常");
            throw new OperateFailException("用户（" + userId + "）状态异常");
        }
        //3、验证手机验证码
        if (StringUtils.isBlank(mobileActiveCode))
        {
            GooagooLog.info("获取邮箱激活码 ：手机验证码（" + mobileActiveCode + "）为空");
            throw new NullException("手机验证码（" + mobileActiveCode + "）为空");
        }
        if (StringUtils.isBlank(userInfo.getMobile()))
        {
            GooagooLog.info("获取邮箱激活码 ：手机号码（" + userInfo.getMobile() + "）为空");
            throw new NullException("手机号码（" + userInfo.getMobile() + "）为空");
        }
        UserMobileCodeExample queryCondition2 = new UserMobileCodeExample();
        queryCondition2.createCriteria().andMobileEqualTo(userInfo.getMobile()).andCaptchaCodeEqualTo(mobileActiveCode).andExpDateGreaterThanOrEqualTo(currentTime).andIsUsedEqualTo("N").andIsDelEqualTo("N");
        List<UserMobileCode> userMobileCodeList = this.userMobileCodeGeneratorCoreService.selectByExample(queryCondition2);
        if (CollectionUtils.isEmpty(userMobileCodeList))
        {
            GooagooLog.info("获取邮箱激活码 ：手机（" + userInfo.getMobile() + "）验证码（" + mobileActiveCode + "）不正确");
            throw new OperateFailException("手机（" + userInfo.getMobile() + "）验证码（" + mobileActiveCode + "）不正确");
        }
        //4、更新手机验证码信息
        UserMobileCode userMobileCode = userMobileCodeList.get(0);
        userMobileCode.setIsUsed("Y");
        userMobileCode.setUseDate(currentTime);
        if (!this.userMobileCodeGeneratorCoreService.updateByPrimaryKeySelective(userMobileCode))
        {
            GooagooLog.error("获取邮箱激活码 ：更新手机验证码信息（" + userMobileCode.toString() + "）异常", null);
            throw new OperateFailException("更新手机验证码信息（" + userMobileCode.toString() + "）异常");
        }
        //5、组装邮箱激活码信息
        UserEmailactiveCode userEmailactiveCode = this.getUserEmailactiveCode(userInfo.getUserId(), currentTime);
        //6、保存邮箱激活码信息
        if (!this.userEmailactiveCodeGeneratorCoreService.insertSelective(userEmailactiveCode))
        {
            GooagooLog.error("获取邮箱激活码：保存邮箱激活码信息（" + userEmailactiveCode.toString() + "）异常", null);
            throw new OperateFailException("保存邮箱激活码信息（" + userEmailactiveCode.toString() + "）异常");
        }

        return userEmailactiveCode.getId();
    }

    @Override
    public String getMobileActiveCode(String mobile) throws Exception
    {
        Date currentTime = new Date();
        //1、验证手机号码
        this.checkMobile(mobile);
        //2、生成手机验证码
        char[] chars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        //3、组装手机验证码数据
        UserMobileCode userMobileCode = new UserMobileCode();
        userMobileCode.setId(UUID.getUUID());
        userMobileCode.setMobile(mobile);
        userMobileCode.setCaptchaCode(RandomStringUtils.random(6, chars));
        userMobileCode.setExpDate(TimeUtils.dateAdd(5, currentTime, 5));
        userMobileCode.setIsUsed("N");
        userMobileCode.setIsDel("N");
        //4、保存短信验证码信息
        if (!this.userMobileCodeGeneratorCoreService.insertSelective(userMobileCode))
        {
            GooagooLog.error("获取手机验证码：保存手机验证码信息（" + userMobileCode.toString() + "）异常", null);
            throw new OperateFailException("保存手机验证码信息（" + userMobileCode.toString() + "）异常");
        }

        return userMobileCode.getCaptchaCode();
    }

    @Override
    public boolean updateMobileActiveCode(String activeCode, String mobile) throws Exception
    {
        Date currentTime = new Date();
        //1、校验手机号码
        if (StringUtils.isBlank(mobile))
        {
            GooagooLog.info("使用手机验证码：手机号码（" + mobile + "）为空");
            throw new NullException("手机号码（" + mobile + "）为空");
        }
        //2、校验手机验证码
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("使用手机验证码：手机（" + mobile + "）验证码（" + activeCode + "）为空");
            throw new NullException("手机（" + mobile + "）验证码（" + activeCode + "）为空");
        }
        UserMobileCodeExample queryCondition = new UserMobileCodeExample();
        queryCondition.createCriteria().andMobileEqualTo(mobile).andCaptchaCodeEqualTo(activeCode).andExpDateGreaterThanOrEqualTo(currentTime).andIsUsedEqualTo("N").andIsDelEqualTo("N");
        List<UserMobileCode> userMobileCodeList = this.userMobileCodeGeneratorCoreService.selectByExample(queryCondition);
        if (CollectionUtils.isEmpty(userMobileCodeList))
        {
            GooagooLog.info("使用手机验证码：手机（" + mobile + "）未有有效的验证码");
            throw new NoDataException("手机（" + mobile + "）未有有效的验证码");
        }
        //3、更新手机验证码状态
        UserMobileCode userMobileCode = userMobileCodeList.get(0);
        userMobileCode.setIsUsed("Y");
        userMobileCode.setUseDate(currentTime);
        if (!this.userMobileCodeGeneratorCoreService.updateByPrimaryKeySelective(userMobileCode))
        {
            GooagooLog.error("使用手机验证码：更新手机验证码信息（" + userMobileCode.toString() + "）异常", null);
            throw new OperateFailException("更新手机验证码信息（" + userMobileCode.toString() + "）异常");
        }

        return true;
    }

    /**
     * 验证邮箱地址
     * @param email
     * @return
     * @throws NullException
     * @throws FormatErrorException
     */
    private boolean checkEmail(String email) throws NullException, FormatErrorException
    {
        if (StringUtils.isBlank(email))
        {
            GooagooLog.info("验证邮箱地址：邮箱地址（" + email + "）为空");
            throw new NullException("邮箱地址（" + email + "）为空");
        }
        if (!DataPatternUtils.chechEmail(email))
        {
            GooagooLog.info("验证邮箱地址：邮箱地址（" + email + "）格式不正确");
            throw new FormatErrorException("邮箱地址（" + email + "）格式不正确");
        }

        return true;
    }

    /**
     * 组装邮箱激活码信息
     * @param activeCode
     * @param userId
     * @param currentTime
     * @return
     */
    private UserEmailactiveCode getUserEmailactiveCode(String userId, Date currentTime)
    {
        UserEmailactiveCode userEmailactiveCode = new UserEmailactiveCode();
        userEmailactiveCode.setId(UUID.getUUID());
        userEmailactiveCode.setUserId(userId);
        userEmailactiveCode.setExpDate(TimeUtils.dateAdd(3, currentTime, 2));
        userEmailactiveCode.setIsActive("N");
        userEmailactiveCode.setIsDel("N");

        return userEmailactiveCode;
    }

    /**
     * 验证手机号码
     * @param mobile
     * @return
     * @throws NullException 
     * @throws FormatErrorException 
     */
    private boolean checkMobile(String mobile) throws NullException, FormatErrorException
    {
        if (StringUtils.isBlank(mobile))
        {
            GooagooLog.info("验证手机号码：手机号码（" + mobile + "）为空");
            throw new NullException("手机号码（" + mobile + "）为空");
        }
        if (!DataPatternUtils.checkMobilePhone(mobile))
        {
            GooagooLog.info("验证手机号码：手机号码（" + mobile + "）格式不正确");
            throw new FormatErrorException("手机号码（" + mobile + "）格式不正确");
        }

        return true;
    }

    @Override
    public String getActiveCode(String activeCode, Integer expireSecond) throws Exception
    {
        if (StringUtils.isBlank(activeCode))
        {
            return null;
        }
        String token = UUID.getUUID();
        RedisStringDao stringDao = new RedisStringDao("login_verification");
        if (expireSecond != null)
        {
            stringDao.set(token, expireSecond, activeCode);
        }
        else
        {
            stringDao.set(token, activeCode);
        }
        return token;
    }
}
