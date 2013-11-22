package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.UserAccountBind;
import com.gooagoo.entity.generator.user.UserAccountBindExample;
import com.gooagoo.entity.generator.user.UserAccountBindKey;

public interface UserAccountBindMapper
{

    public Integer countByExample(UserAccountBindExample userAccountBindExample);

    public List<UserAccountBind> selectByExample(UserAccountBindExample userAccountBindExample);

    public UserAccountBind selectByPrimaryKey(UserAccountBindKey userAccountBindKey);

}
