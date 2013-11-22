package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserInfoKey;

public interface UserInfoMapper
{

    public Integer countByExample(UserInfoExample userInfoExample);

    public List<UserInfo> selectByExample(UserInfoExample userInfoExample);

    public UserInfo selectByPrimaryKey(UserInfoKey userInfoKey);

    public Integer deleteByExample(UserInfoExample userInfoExample);

    public Integer deleteByPrimaryKey(UserInfoKey userInfoKey);

    public Integer insertSelective(UserInfo userInfo);

    public Integer updateAllByExample(@Param("record") UserInfo userInfo, @Param("example") UserInfoExample userInfoExample);

    public Integer updateByExampleSelective(@Param("record") UserInfo userInfo, @Param("example") UserInfoExample userInfoExample);

    public Integer updateByPrimaryKeySelective(UserInfo userInfo);

}
