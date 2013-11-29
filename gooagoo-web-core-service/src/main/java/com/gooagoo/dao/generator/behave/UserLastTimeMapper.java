package com.gooagoo.dao.generator.behave;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;
import com.gooagoo.entity.generator.behave.UserLastTimeKey;

public interface UserLastTimeMapper
{

    public Integer countByExample(UserLastTimeExample userLastTimeExample);

    public List<UserLastTime> selectByExample(UserLastTimeExample userLastTimeExample);

    public UserLastTime selectByPrimaryKey(UserLastTimeKey userLastTimeKey);

    public Integer deleteByExample(UserLastTimeExample userLastTimeExample);

    public Integer deleteByPrimaryKey(UserLastTimeKey userLastTimeKey);

    public Integer insertSelective(UserLastTime userLastTime);

    public Integer updateAllByExample(@Param("record") UserLastTime userLastTime, @Param("example") UserLastTimeExample userLastTimeExample);

    public Integer updateByExampleSelective(@Param("record") UserLastTime userLastTime, @Param("example") UserLastTimeExample userLastTimeExample);

    public Integer updateByPrimaryKeySelective(UserLastTime userLastTime);

}
