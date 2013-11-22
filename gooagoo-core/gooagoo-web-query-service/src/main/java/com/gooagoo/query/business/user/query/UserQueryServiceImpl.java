package com.gooagoo.query.business.user.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.user.query.UserQueryService;
import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserMobileInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.user.UserProfileGeneratorQueryService;
import com.gooagoo.entity.business.user.UserDetailInfo;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserProfile;

/**
 * 用户
 */

@Service
public class UserQueryServiceImpl implements UserQueryService
{

    @Autowired
    private UserInfoGeneratorQueryService userInfoGeneratorQueryService;

    @Autowired
    private UserMobileInfoGeneratorQueryService userMobileInfoGeneratorQueryService;

    @Autowired
    private UserProfileGeneratorQueryService userProfileGeneratorQueryService;

    @Override
    public UserDetailInfo findUserInfo(String userId) throws Exception
    {
        UserDetailInfo userDetailInfo = null;
        UserInfo userInfo = this.userInfoGeneratorQueryService.selectUnDelByPrimaryKey(userId);
        if (userInfo != null)
        {
            userDetailInfo = new UserDetailInfo();
            userDetailInfo.setUserInfo(userInfo);//个人用户表
            UserMobileInfo userMobileInfo = this.userMobileInfoGeneratorQueryService.selectByPrimaryKey(userId);
            userDetailInfo.setUserMobileInfo(userMobileInfo);//用户移动终端信息
            UserProfile userProfile = this.userProfileGeneratorQueryService.selectByPrimaryKey(userId);
            userDetailInfo.setUserProfile(userProfile);//用户辅助信息
        }
        return userDetailInfo;
    }

}
