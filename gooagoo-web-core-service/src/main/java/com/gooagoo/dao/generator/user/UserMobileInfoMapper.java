package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoExample;
import com.gooagoo.entity.generator.user.UserMobileInfoKey;

public interface UserMobileInfoMapper
{

    public Integer countByExample(UserMobileInfoExample userMobileInfoExample);

    public List<UserMobileInfo> selectByExample(UserMobileInfoExample userMobileInfoExample);

    public UserMobileInfo selectByPrimaryKey(UserMobileInfoKey userMobileInfoKey);

    public Integer deleteByExample(UserMobileInfoExample userMobileInfoExample);

    public Integer deleteByPrimaryKey(UserMobileInfoKey userMobileInfoKey);

    public Integer insertSelective(UserMobileInfo userMobileInfo);

    public Integer updateAllByExample(@Param("record") UserMobileInfo userMobileInfo, @Param("example") UserMobileInfoExample userMobileInfoExample);

    public Integer updateByExampleSelective(@Param("record") UserMobileInfo userMobileInfo, @Param("example") UserMobileInfoExample userMobileInfoExample);

    public Integer updateByPrimaryKeySelective(UserMobileInfo userMobileInfo);

}
