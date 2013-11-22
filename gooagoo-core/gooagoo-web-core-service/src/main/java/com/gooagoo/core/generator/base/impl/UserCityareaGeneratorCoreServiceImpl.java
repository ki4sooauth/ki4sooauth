package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.UserCityareaGeneratorCoreService;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.entity.generator.base.UserCityareaKey;
import com.gooagoo.dao.generator.base.UserCityareaMapper;

@Service
public class UserCityareaGeneratorCoreServiceImpl implements UserCityareaGeneratorCoreService
{

    @Autowired
    private UserCityareaMapper userCityareaMapper;

    @Override
    public Integer countByExample(UserCityareaExample userCityareaExample) 
    {
        return this.userCityareaMapper.countByExample(userCityareaExample);
    }

    @Override
    public List<UserCityarea> selectByExample(UserCityareaExample userCityareaExample) 
    {
        return this.userCityareaMapper.selectByExample(userCityareaExample);
    }

    @Override
    public UserCityarea selectUnDelByPrimaryKey(Integer primaryKey) 
    {
        UserCityareaKey userCityareaKey = new UserCityareaKey();
        userCityareaKey.setIsDel("N");
        userCityareaKey.setId(primaryKey);
        return this.userCityareaMapper.selectByPrimaryKey(userCityareaKey);
    }

    @Override
    public UserCityarea selectByPrimaryKey(Integer primaryKey) 
    {
        UserCityareaKey userCityareaKey = new UserCityareaKey();
        userCityareaKey.setId(primaryKey);
        return this.userCityareaMapper.selectByPrimaryKey(userCityareaKey);
    }

    @Override
    public boolean physicalDeleteByExample(UserCityareaExample userCityareaExample) 
    {
        return this.userCityareaMapper.deleteByExample(userCityareaExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(Integer primaryKey) 
    {
        UserCityareaKey userCityareaKey = new UserCityareaKey();
        userCityareaKey.setId(primaryKey);
        return this.userCityareaMapper.deleteByPrimaryKey(userCityareaKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserCityareaExample userCityareaExample) 
    {
        UserCityarea userCityarea = new UserCityarea();
        userCityarea.setIsDel("Y");
        return this.userCityareaMapper.updateByExampleSelective(userCityarea,userCityareaExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer primaryKey) 
    {
        UserCityarea userCityarea = new UserCityarea();
        userCityarea.setId(primaryKey);
        userCityarea.setIsDel("Y");
        return this.userCityareaMapper.updateByPrimaryKeySelective(userCityarea) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserCityarea userCityarea) 
    {
        return this.userCityareaMapper.insertSelective(userCityarea) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserCityarea userCityarea,UserCityareaExample userCityareaExample) 
    {
        return this.userCityareaMapper.updateByExampleSelective(userCityarea,userCityareaExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserCityarea userCityarea) 
    {
        return this.userCityareaMapper.updateByPrimaryKeySelective(userCityarea) > 0 ? true : false;
    }

}
