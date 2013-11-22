package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.UserSecurityCard;
import com.gooagoo.entity.generator.user.UserSecurityCardExample;
import com.gooagoo.entity.generator.user.UserSecurityCardKey;

public interface UserSecurityCardMapper
{

    public Integer countByExample(UserSecurityCardExample userSecurityCardExample);

    public List<UserSecurityCard> selectByExample(UserSecurityCardExample userSecurityCardExample);

    public UserSecurityCard selectByPrimaryKey(UserSecurityCardKey userSecurityCardKey);

    public Integer deleteByExample(UserSecurityCardExample userSecurityCardExample);

    public Integer deleteByPrimaryKey(UserSecurityCardKey userSecurityCardKey);

    public Integer insertSelective(UserSecurityCard userSecurityCard);

    public Integer updateAllByExample(@Param("record") UserSecurityCard userSecurityCard, @Param("example") UserSecurityCardExample userSecurityCardExample);

    public Integer updateByExampleSelective(@Param("record") UserSecurityCard userSecurityCard, @Param("example") UserSecurityCardExample userSecurityCardExample);

    public Integer updateByPrimaryKeySelective(UserSecurityCard userSecurityCard);

}
