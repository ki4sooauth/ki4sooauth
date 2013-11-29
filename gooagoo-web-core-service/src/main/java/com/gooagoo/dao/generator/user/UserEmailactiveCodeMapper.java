package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeExample;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeKey;

public interface UserEmailactiveCodeMapper
{

    public Integer countByExample(UserEmailactiveCodeExample userEmailactiveCodeExample);

    public List<UserEmailactiveCode> selectByExample(UserEmailactiveCodeExample userEmailactiveCodeExample);

    public UserEmailactiveCode selectByPrimaryKey(UserEmailactiveCodeKey userEmailactiveCodeKey);

    public Integer deleteByExample(UserEmailactiveCodeExample userEmailactiveCodeExample);

    public Integer deleteByPrimaryKey(UserEmailactiveCodeKey userEmailactiveCodeKey);

    public Integer insertSelective(UserEmailactiveCode userEmailactiveCode);

    public Integer updateAllByExample(@Param("record") UserEmailactiveCode userEmailactiveCode, @Param("example") UserEmailactiveCodeExample userEmailactiveCodeExample);

    public Integer updateByExampleSelective(@Param("record") UserEmailactiveCode userEmailactiveCode, @Param("example") UserEmailactiveCodeExample userEmailactiveCodeExample);

    public Integer updateByPrimaryKeySelective(UserEmailactiveCode userEmailactiveCode);

}
