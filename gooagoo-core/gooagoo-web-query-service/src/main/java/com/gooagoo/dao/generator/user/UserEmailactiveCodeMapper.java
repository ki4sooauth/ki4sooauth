package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeExample;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeKey;

public interface UserEmailactiveCodeMapper
{

    public Integer countByExample(UserEmailactiveCodeExample userEmailactiveCodeExample);

    public List<UserEmailactiveCode> selectByExample(UserEmailactiveCodeExample userEmailactiveCodeExample);

    public UserEmailactiveCode selectByPrimaryKey(UserEmailactiveCodeKey userEmailactiveCodeKey);

}
