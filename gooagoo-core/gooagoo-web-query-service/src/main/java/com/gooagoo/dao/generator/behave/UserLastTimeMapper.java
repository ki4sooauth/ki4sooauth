package com.gooagoo.dao.generator.behave;

import java.util.List;

import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;
import com.gooagoo.entity.generator.behave.UserLastTimeKey;

public interface UserLastTimeMapper
{

    public Integer countByExample(UserLastTimeExample userLastTimeExample);

    public List<UserLastTime> selectByExample(UserLastTimeExample userLastTimeExample);

    public UserLastTime selectByPrimaryKey(UserLastTimeKey userLastTimeKey);

}
