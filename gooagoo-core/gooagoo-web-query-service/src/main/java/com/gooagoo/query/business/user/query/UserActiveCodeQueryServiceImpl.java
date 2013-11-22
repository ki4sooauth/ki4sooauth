package com.gooagoo.query.business.user.query;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.user.query.UserActiveCodeQueryService;
import com.gooagoo.api.generator.query.user.UserEmailactiveCodeGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserMobileCodeGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.redis.data.RedisStringDao;

@Service
public class UserActiveCodeQueryServiceImpl implements UserActiveCodeQueryService
{
    @Autowired
    private UserEmailactiveCodeGeneratorQueryService userEmailactiveCodeGeneratorQueryService;
    @Autowired
    private UserMobileCodeGeneratorQueryService userMobileCodeGeneratorQueryService;

    @Override
    public boolean checkEmailActiveCode(String activeCode) throws Exception
    {
        Date currentTime = new Date();
        //1、校验邮箱激活码是否为空
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + activeCode + "）为空");
            throw new NullException("邮箱激活码（" + activeCode + "）为空");
        }
        //2、校验邮箱激活码是否正确
        UserEmailactiveCode userEmailactiveCode = this.userEmailactiveCodeGeneratorQueryService.selectByPrimaryKey(activeCode);
        if (userEmailactiveCode == null || "Y".equals(userEmailactiveCode.getIsDel()))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + activeCode + "）不存在或已被删除");
            throw new NoDataException("邮箱激活码（" + activeCode + "）不存在或已被删除");
        }
        if ("Y".equals(userEmailactiveCode.getIsActive()))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + activeCode + "）已被使用");
            throw new NoDataException("邮箱激活码（" + activeCode + "）已被使用");
        }
        if (currentTime.after(userEmailactiveCode.getExpDate()))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + activeCode + "）已过期");
            throw new NoDataException("邮箱激活码（" + activeCode + "）已过期");
        }

        return true;
    }

    @Override
    public boolean checkActiveCodeForBindMobile(String userId, String activeCode) throws Exception
    {
        Date currentTime = new Date();
        //1、校验邮箱激活码是否为空
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + activeCode + "）为空");
            throw new NullException("邮箱激活码（" + activeCode + "）为空");
        }
        //2、校验邮箱激活码是否正确
        UserEmailactiveCode userEmailactiveCode = this.userEmailactiveCodeGeneratorQueryService.selectByPrimaryKey(activeCode);
        if (userEmailactiveCode == null || "Y".equals(userEmailactiveCode.getIsDel()))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + activeCode + "）不存在或已被删除");
            throw new NoDataException("邮箱激活码（" + activeCode + "）不存在或已被删除");
        }
        if ("Y".equals(userEmailactiveCode.getIsActive()))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + activeCode + "）已被使用");
            throw new NoDataException("邮箱激活码（" + activeCode + "）已被使用");
        }
        if (currentTime.after(userEmailactiveCode.getExpDate()))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + activeCode + "）已过期");
            throw new NoDataException("邮箱激活码（" + activeCode + "）已过期");
        }
        //3、校验邮箱激活码是否属于登录用户
        if (!userEmailactiveCode.getUserId().equals(userId))
        {
            GooagooLog.info("校验邮箱激活码：邮箱激活码（" + userEmailactiveCode.getUserId() + "）不属于登录用户（" + userId + "）");
            throw new NoDataException("邮箱激活码（" + userEmailactiveCode.getUserId() + "）不属于登录用户（" + userId + "）");
        }

        return true;
    }

    @Override
    public boolean checkMobileActiveCode(String activeCode, String mobile) throws Exception
    {
        Date currentTime = new Date();
        //1、校验手机验证码是否为空
        if (StringUtils.isBlank(activeCode))
        {
            GooagooLog.info("校验手机验证码：手机（" + mobile + "）验证码（" + activeCode + "）为空");
            throw new NullException("手机（" + mobile + "）验证码（" + activeCode + "）为空");
        }
        //2、校验手机验证码是否正确
        UserMobileCodeExample queryCondition = new UserMobileCodeExample();
        queryCondition.createCriteria().andMobileEqualTo(mobile).andCaptchaCodeEqualTo(activeCode).andExpDateGreaterThanOrEqualTo(currentTime).andIsUsedEqualTo("N").andIsDelEqualTo("N");
        Integer count = this.userMobileCodeGeneratorQueryService.countByExample(queryCondition);
        if (count == null || count == 0)
        {
            GooagooLog.info("校验手机验证码：手机（" + mobile + "）验证码（" + activeCode + "）无效");
            throw new NoDataException("手机（" + mobile + "）验证码（" + activeCode + "）无效");
        }
        return true;
    }

    @Override
    public boolean checkActiveCode(String token, String activeCode) throws Exception
    {
        if (StringUtils.isBlank(token) || StringUtils.isBlank(activeCode))
        {
            return false;
        }
        RedisStringDao stringDao = new RedisStringDao("login_verification");
        String str = stringDao.get(token);
        if (StringUtils.isBlank(str))
        {
            return false;
        }

        return str.equalsIgnoreCase(activeCode);
    }

}
