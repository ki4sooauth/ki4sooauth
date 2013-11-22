package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.UserCityareaGeneratorQueryService;
import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.entity.generator.base.UserCityareaKey;
import com.gooagoo.dao.generator.base.UserCityareaMapper;

@Service
public class UserCityareaGeneratorQueryServiceImpl implements UserCityareaGeneratorQueryService
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

}
