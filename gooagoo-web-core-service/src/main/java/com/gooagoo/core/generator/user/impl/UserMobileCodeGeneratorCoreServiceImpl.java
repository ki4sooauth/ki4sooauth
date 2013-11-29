package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.UserMobileCodeGeneratorCoreService;
import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.entity.generator.user.UserMobileCodeKey;
import com.gooagoo.dao.generator.user.UserMobileCodeMapper;

@Service
public class UserMobileCodeGeneratorCoreServiceImpl implements UserMobileCodeGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserMobileCodeExample userMobileCodeExample) 
    {
        return this.userMobileCodeMapper.deleteByExample(userMobileCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserMobileCodeKey userMobileCodeKey = new UserMobileCodeKey();
        userMobileCodeKey.setId(primaryKey);
        return this.userMobileCodeMapper.deleteByPrimaryKey(userMobileCodeKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserMobileCodeExample userMobileCodeExample) 
    {
        UserMobileCode userMobileCode = new UserMobileCode();
        userMobileCode.setIsDel("Y");
        return this.userMobileCodeMapper.updateByExampleSelective(userMobileCode,userMobileCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserMobileCode userMobileCode = new UserMobileCode();
        userMobileCode.setId(primaryKey);
        userMobileCode.setIsDel("Y");
        return this.userMobileCodeMapper.updateByPrimaryKeySelective(userMobileCode) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserMobileCode userMobileCode) 
    {
        return this.userMobileCodeMapper.insertSelective(userMobileCode) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserMobileCode userMobileCode,UserMobileCodeExample userMobileCodeExample) 
    {
        return this.userMobileCodeMapper.updateByExampleSelective(userMobileCode,userMobileCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserMobileCode userMobileCode) 
    {
        return this.userMobileCodeMapper.updateByPrimaryKeySelective(userMobileCode) > 0 ? true : false;
    }

}
