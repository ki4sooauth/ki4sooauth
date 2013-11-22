package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.UserSecurityCardGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserSecurityCard;
import com.gooagoo.entity.generator.user.UserSecurityCardExample;
import com.gooagoo.entity.generator.user.UserSecurityCardKey;
import com.gooagoo.dao.generator.user.UserSecurityCardMapper;

@Service
public class UserSecurityCardGeneratorQueryServiceImpl implements UserSecurityCardGeneratorQueryService
{

    @Autowired
    private UserSecurityCardMapper userSecurityCardMapper;

    @Override
    public Integer countByExample(UserSecurityCardExample userSecurityCardExample) 
    {
        return this.userSecurityCardMapper.countByExample(userSecurityCardExample);
    }

    @Override
    public List<UserSecurityCard> selectByExample(UserSecurityCardExample userSecurityCardExample) 
    {
        return this.userSecurityCardMapper.selectByExample(userSecurityCardExample);
    }

    @Override
    public UserSecurityCard selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserSecurityCardKey userSecurityCardKey = new UserSecurityCardKey();
        userSecurityCardKey.setIsDel("N");
        userSecurityCardKey.setId(primaryKey);
        return this.userSecurityCardMapper.selectByPrimaryKey(userSecurityCardKey);
    }

    @Override
    public UserSecurityCard selectByPrimaryKey(String primaryKey) 
    {
        UserSecurityCardKey userSecurityCardKey = new UserSecurityCardKey();
        userSecurityCardKey.setId(primaryKey);
        return this.userSecurityCardMapper.selectByPrimaryKey(userSecurityCardKey);
    }

}
