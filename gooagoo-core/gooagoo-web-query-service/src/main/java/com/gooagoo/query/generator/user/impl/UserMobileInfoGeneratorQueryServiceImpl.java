package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.UserMobileInfoGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoExample;
import com.gooagoo.entity.generator.user.UserMobileInfoKey;
import com.gooagoo.dao.generator.user.UserMobileInfoMapper;

@Service
public class UserMobileInfoGeneratorQueryServiceImpl implements UserMobileInfoGeneratorQueryService
{

    @Autowired
    private UserMobileInfoMapper userMobileInfoMapper;

    @Override
    public Integer countByExample(UserMobileInfoExample userMobileInfoExample) 
    {
        return this.userMobileInfoMapper.countByExample(userMobileInfoExample);
    }

    @Override
    public List<UserMobileInfo> selectByExample(UserMobileInfoExample userMobileInfoExample) 
    {
        return this.userMobileInfoMapper.selectByExample(userMobileInfoExample);
    }

    @Override
    public UserMobileInfo selectByPrimaryKey(String primaryKey) 
    {
        UserMobileInfoKey userMobileInfoKey = new UserMobileInfoKey();
        userMobileInfoKey.setUserId(primaryKey);
        return this.userMobileInfoMapper.selectByPrimaryKey(userMobileInfoKey);
    }

}
