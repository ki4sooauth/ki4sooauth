package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.entity.generator.user.UserProfileExample;
import com.gooagoo.entity.generator.user.UserProfileKey;

public interface UserProfileMapper
{

    public Integer countByExample(UserProfileExample userProfileExample);

    public List<UserProfile> selectByExample(UserProfileExample userProfileExample);

    public UserProfile selectByPrimaryKey(UserProfileKey userProfileKey);

}
