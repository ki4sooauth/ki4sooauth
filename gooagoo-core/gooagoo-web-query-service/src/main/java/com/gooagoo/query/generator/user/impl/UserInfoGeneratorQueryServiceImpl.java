package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.UserInfoGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserInfoKey;
import com.gooagoo.dao.generator.user.UserInfoMapper;

@Service
public class UserInfoGeneratorQueryServiceImpl implements UserInfoGeneratorQueryService
{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Integer countByExample(UserInfoExample userInfoExample) 
    {
        return this.userInfoMapper.countByExample(userInfoExample);
    }

    @Override
    public List<UserInfo> selectByExample(UserInfoExample userInfoExample) 
    {
        return this.userInfoMapper.selectByExample(userInfoExample);
    }

    @Override
    public UserInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserInfoKey userInfoKey = new UserInfoKey();
        userInfoKey.setIsDel("N");
        userInfoKey.setUserId(primaryKey);
        return this.userInfoMapper.selectByPrimaryKey(userInfoKey);
    }

    @Override
    public UserInfo selectByPrimaryKey(String primaryKey) 
    {
        UserInfoKey userInfoKey = new UserInfoKey();
        userInfoKey.setUserId(primaryKey);
        return this.userInfoMapper.selectByPrimaryKey(userInfoKey);
    }

}
