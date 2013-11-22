package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.entity.generator.base.UserCityareaKey;

public interface UserCityareaMapper
{

    public Integer countByExample(UserCityareaExample userCityareaExample);

    public List<UserCityarea> selectByExample(UserCityareaExample userCityareaExample);

    public UserCityarea selectByPrimaryKey(UserCityareaKey userCityareaKey);

}
