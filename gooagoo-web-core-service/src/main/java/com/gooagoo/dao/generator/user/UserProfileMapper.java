package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.entity.generator.user.UserProfileExample;
import com.gooagoo.entity.generator.user.UserProfileKey;

public interface UserProfileMapper
{

    public Integer countByExample(UserProfileExample userProfileExample);

    public List<UserProfile> selectByExample(UserProfileExample userProfileExample);

    public UserProfile selectByPrimaryKey(UserProfileKey userProfileKey);

    public Integer deleteByExample(UserProfileExample userProfileExample);

    public Integer deleteByPrimaryKey(UserProfileKey userProfileKey);

    public Integer insertSelective(UserProfile userProfile);

    public Integer updateAllByExample(@Param("record") UserProfile userProfile, @Param("example") UserProfileExample userProfileExample);

    public Integer updateByExampleSelective(@Param("record") UserProfile userProfile, @Param("example") UserProfileExample userProfileExample);

    public Integer updateByPrimaryKeySelective(UserProfile userProfile);

}
