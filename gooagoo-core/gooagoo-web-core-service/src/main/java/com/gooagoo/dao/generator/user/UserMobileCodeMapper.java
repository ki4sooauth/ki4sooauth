package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.entity.generator.user.UserMobileCodeKey;

public interface UserMobileCodeMapper
{

    public Integer countByExample(UserMobileCodeExample userMobileCodeExample);

    public List<UserMobileCode> selectByExample(UserMobileCodeExample userMobileCodeExample);

    public UserMobileCode selectByPrimaryKey(UserMobileCodeKey userMobileCodeKey);

    public Integer deleteByExample(UserMobileCodeExample userMobileCodeExample);

    public Integer deleteByPrimaryKey(UserMobileCodeKey userMobileCodeKey);

    public Integer insertSelective(UserMobileCode userMobileCode);

    public Integer updateAllByExample(@Param("record") UserMobileCode userMobileCode, @Param("example") UserMobileCodeExample userMobileCodeExample);

    public Integer updateByExampleSelective(@Param("record") UserMobileCode userMobileCode, @Param("example") UserMobileCodeExample userMobileCodeExample);

    public Integer updateByPrimaryKeySelective(UserMobileCode userMobileCode);

}
