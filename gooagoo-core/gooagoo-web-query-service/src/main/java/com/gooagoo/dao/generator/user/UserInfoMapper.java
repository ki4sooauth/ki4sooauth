package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.UserInfo;
import com.gooagoo.entity.generator.user.UserInfoExample;
import com.gooagoo.entity.generator.user.UserInfoKey;

public interface UserInfoMapper
{

    public Integer countByExample(UserInfoExample userInfoExample);

    public List<UserInfo> selectByExample(UserInfoExample userInfoExample);

    public UserInfo selectByPrimaryKey(UserInfoKey userInfoKey);

}
