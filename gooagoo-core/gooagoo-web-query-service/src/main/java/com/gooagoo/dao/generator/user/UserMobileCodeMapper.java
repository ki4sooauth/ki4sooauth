package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.UserMobileCode;
import com.gooagoo.entity.generator.user.UserMobileCodeExample;
import com.gooagoo.entity.generator.user.UserMobileCodeKey;

public interface UserMobileCodeMapper
{

    public Integer countByExample(UserMobileCodeExample userMobileCodeExample);

    public List<UserMobileCode> selectByExample(UserMobileCodeExample userMobileCodeExample);

    public UserMobileCode selectByPrimaryKey(UserMobileCodeKey userMobileCodeKey);

}
