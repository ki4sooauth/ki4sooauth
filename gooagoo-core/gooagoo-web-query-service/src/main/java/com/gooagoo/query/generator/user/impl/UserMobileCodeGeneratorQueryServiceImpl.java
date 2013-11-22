package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.UserMobileCodeGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.entity.generator.user.UserMobileCodeKey;
import com.gooagoo.dao.generator.user.UserMobileCodeMapper;

@Service
public class UserMobileCodeGeneratorQueryServiceImpl implements UserMobileCodeGeneratorQueryService
{

    @Autowired
    private UserMobileCodeMapper userMobileCodeMapper;

    @Override
    public Integer countByExample(UserMobileCodeExample userMobileCodeExample) 
    {
        return this.userMobileCodeMapper.countByExample(userMobileCodeExample);
    }

    @Override
    public List<UserMobileCode> selectByExample(UserMobileCodeExample userMobileCodeExample) 
    {
        return this.userMobileCodeMapper.selectByExample(userMobileCodeExample);
    }

    @Override
    public UserMobileCode selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserMobileCodeKey userMobileCodeKey = new UserMobileCodeKey();
        userMobileCodeKey.setIsDel("N");
        userMobileCodeKey.setId(primaryKey);
        return this.userMobileCodeMapper.selectByPrimaryKey(userMobileCodeKey);
    }

    @Override
    public UserMobileCode selectByPrimaryKey(String primaryKey) 
    {
        UserMobileCodeKey userMobileCodeKey = new UserMobileCodeKey();
        userMobileCodeKey.setId(primaryKey);
        return this.userMobileCodeMapper.selectByPrimaryKey(userMobileCodeKey);
    }

}
