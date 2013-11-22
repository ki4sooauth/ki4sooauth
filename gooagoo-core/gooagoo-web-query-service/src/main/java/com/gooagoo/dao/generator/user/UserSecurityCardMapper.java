package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.UserSecurityCard;
import com.gooagoo.entity.generator.user.UserSecurityCardExample;
import com.gooagoo.entity.generator.user.UserSecurityCardKey;

public interface UserSecurityCardMapper
{

    public Integer countByExample(UserSecurityCardExample userSecurityCardExample);

    public List<UserSecurityCard> selectByExample(UserSecurityCardExample userSecurityCardExample);

    public UserSecurityCard selectByPrimaryKey(UserSecurityCardKey userSecurityCardKey);

}
