package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.UserAccountBind;
import com.gooagoo.entity.generator.user.UserAccountBindExample;
import com.gooagoo.entity.generator.user.UserAccountBindKey;

public interface UserAccountBindMapper
{

    public Integer countByExample(UserAccountBindExample userAccountBindExample);

    public List<UserAccountBind> selectByExample(UserAccountBindExample userAccountBindExample);

    public UserAccountBind selectByPrimaryKey(UserAccountBindKey userAccountBindKey);

    public Integer deleteByExample(UserAccountBindExample userAccountBindExample);

    public Integer deleteByPrimaryKey(UserAccountBindKey userAccountBindKey);

    public Integer insertSelective(UserAccountBind userAccountBind);

    public Integer updateAllByExample(@Param("record") UserAccountBind userAccountBind, @Param("example") UserAccountBindExample userAccountBindExample);

    public Integer updateByExampleSelective(@Param("record") UserAccountBind userAccountBind, @Param("example") UserAccountBindExample userAccountBindExample);

    public Integer updateByPrimaryKeySelective(UserAccountBind userAccountBind);

}
