package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.UserMobileInfo;
import com.gooagoo.entity.generator.user.UserMobileInfoExample;
import com.gooagoo.entity.generator.user.UserMobileInfoKey;

public interface UserMobileInfoMapper
{

    public Integer countByExample(UserMobileInfoExample userMobileInfoExample);

    public List<UserMobileInfo> selectByExample(UserMobileInfoExample userMobileInfoExample);

    public UserMobileInfo selectByPrimaryKey(UserMobileInfoKey userMobileInfoKey);

}
