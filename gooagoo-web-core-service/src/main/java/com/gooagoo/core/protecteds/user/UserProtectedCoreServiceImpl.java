package com.gooagoo.core.protecteds.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.UserInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.user.UserProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.user.UserInfo;

@Service
public class UserProtectedCoreServiceImpl implements UserProtectedCoreService

{

    @Autowired
    private UserInfoGeneratorCoreService userInfoGeneratorCoreService;

    @Override
    public boolean checkUserStatus(String userId)
    {
        if (StringUtils.isBlank(userId))
        {
            GooagooLog.info("检查用户状态：用户ID（" + userId + "）为空");
            return false;
        }
        UserInfo userInfo = this.userInfoGeneratorCoreService.selectByPrimaryKey(userId);
        if (userInfo == null || "Y".equals(userInfo.getIsDel()))
        {
            GooagooLog.info("检查用户状态：用户（" + userId + "）不存在或被删除");
            return false;
        }
        if ("N".equals(userInfo.getIsActiveEmail()))
        {
            GooagooLog.info("检查用户状态：用户（" + userId + "）邮箱未激活");
            return false;
        }
        if ("L".equals(userInfo.getUserStatus()))
        {
            GooagooLog.info("检查用户状态：用户（" + userId + "）状态已被锁定");
            return false;
        }

        return true;
    }

    @Override
    public UserInfo getNormalUserInfo(String userId)
    {
        if (StringUtils.isBlank(userId))
        {
            GooagooLog.info("获取状态正常的用户信息：用户ID（" + userId + "）为空");
            return null;
        }
        UserInfo userInfo = this.userInfoGeneratorCoreService.selectByPrimaryKey(userId);
        if (userInfo == null || "Y".equals(userInfo.getIsDel()))
        {
            GooagooLog.info("获取状态正常的用户信息：用户（" + userId + "）不存在或被删除");
            throw null;
        }
        if ("N".equals(userInfo.getIsActiveEmail()) || "L".equals(userInfo.getUserStatus()))
        {
            GooagooLog.info("获取状态正常的用户信息：用户（" + userId + "）状态异常");
            throw null;
        }

        return userInfo;
    }

}
