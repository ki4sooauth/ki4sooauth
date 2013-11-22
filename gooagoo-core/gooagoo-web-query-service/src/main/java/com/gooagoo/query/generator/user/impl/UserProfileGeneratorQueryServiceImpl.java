package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.UserProfileGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserProfile;
import com.gooagoo.entity.generator.user.UserProfileExample;
import com.gooagoo.entity.generator.user.UserProfileKey;
import com.gooagoo.dao.generator.user.UserProfileMapper;

@Service
public class UserProfileGeneratorQueryServiceImpl implements UserProfileGeneratorQueryService
{

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public Integer countByExample(UserProfileExample userProfileExample) 
    {
        return this.userProfileMapper.countByExample(userProfileExample);
    }

    @Override
    public List<UserProfile> selectByExample(UserProfileExample userProfileExample) 
    {
        return this.userProfileMapper.selectByExample(userProfileExample);
    }

    @Override
    public UserProfile selectByPrimaryKey(String primaryKey) 
    {
        UserProfileKey userProfileKey = new UserProfileKey();
        userProfileKey.setUserId(primaryKey);
        return this.userProfileMapper.selectByPrimaryKey(userProfileKey);
    }

}
