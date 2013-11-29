package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.UserCityarea;
import com.gooagoo.entity.generator.base.UserCityareaExample;
import com.gooagoo.entity.generator.base.UserCityareaKey;

public interface UserCityareaMapper
{

    public Integer countByExample(UserCityareaExample userCityareaExample);

    public List<UserCityarea> selectByExample(UserCityareaExample userCityareaExample);

    public UserCityarea selectByPrimaryKey(UserCityareaKey userCityareaKey);

    public Integer deleteByExample(UserCityareaExample userCityareaExample);

    public Integer deleteByPrimaryKey(UserCityareaKey userCityareaKey);

    public Integer insertSelective(UserCityarea userCityarea);

    public Integer updateAllByExample(@Param("record") UserCityarea userCityarea, @Param("example") UserCityareaExample userCityareaExample);

    public Integer updateByExampleSelective(@Param("record") UserCityarea userCityarea, @Param("example") UserCityareaExample userCityareaExample);

    public Integer updateByPrimaryKeySelective(UserCityarea userCityarea);

}
