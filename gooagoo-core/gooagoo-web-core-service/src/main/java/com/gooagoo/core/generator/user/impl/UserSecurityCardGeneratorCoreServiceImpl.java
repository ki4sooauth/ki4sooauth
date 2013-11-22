package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.UserSecurityCardGeneratorCoreService;
import com.gooagoo.entity.generator.user.UserSecurityCard;
import com.gooagoo.entity.generator.user.UserSecurityCardExample;
import com.gooagoo.entity.generator.user.UserSecurityCardKey;
import com.gooagoo.dao.generator.user.UserSecurityCardMapper;

@Service
public class UserSecurityCardGeneratorCoreServiceImpl implements UserSecurityCardGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserSecurityCardExample userSecurityCardExample) 
    {
        return this.userSecurityCardMapper.deleteByExample(userSecurityCardExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserSecurityCardKey userSecurityCardKey = new UserSecurityCardKey();
        userSecurityCardKey.setId(primaryKey);
        return this.userSecurityCardMapper.deleteByPrimaryKey(userSecurityCardKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserSecurityCardExample userSecurityCardExample) 
    {
        UserSecurityCard userSecurityCard = new UserSecurityCard();
        userSecurityCard.setIsDel("Y");
        return this.userSecurityCardMapper.updateByExampleSelective(userSecurityCard,userSecurityCardExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserSecurityCard userSecurityCard = new UserSecurityCard();
        userSecurityCard.setId(primaryKey);
        userSecurityCard.setIsDel("Y");
        return this.userSecurityCardMapper.updateByPrimaryKeySelective(userSecurityCard) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserSecurityCard userSecurityCard) 
    {
        return this.userSecurityCardMapper.insertSelective(userSecurityCard) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserSecurityCard userSecurityCard,UserSecurityCardExample userSecurityCardExample) 
    {
        return this.userSecurityCardMapper.updateByExampleSelective(userSecurityCard,userSecurityCardExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserSecurityCard userSecurityCard) 
    {
        return this.userSecurityCardMapper.updateByPrimaryKeySelective(userSecurityCard) > 0 ? true : false;
    }

}
