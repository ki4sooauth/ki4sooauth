package com.gooagoo.entity.business.user;

import java.io.Serializable;

import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserProfile;

/**
 * 个人用户详细信息表
 */

public class UserDetailInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String token;//token值

    private UserInfo userInfo;

    private UserProfile userProfile;

    private UserMobileInfo userMobileInfo;

    private String clientInfoJson;//客户端信息JSON串

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public UserInfo getUserInfo()
    {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }

    public UserProfile getUserProfile()
    {
        return this.userProfile;
    }

    public void setUserProfile(UserProfile userProfile)
    {
        this.userProfile = userProfile;
    }

    public UserMobileInfo getUserMobileInfo()
    {
        return this.userMobileInfo;
    }

    public void setUserMobileInfo(UserMobileInfo userMobileInfo)
    {
        this.userMobileInfo = userMobileInfo;
    }

    public String getClientInfoJson()
    {
        return clientInfoJson;
    }

    public void setClientInfoJson(String clientInfoJson)
    {
        this.clientInfoJson = clientInfoJson;
    }

}
