package com.gooagoo.api.business.core.user.behave;

import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;

public interface UserLastTimeCoreService

{
    /**
     * 此方法对应数据库表user_last_time用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param userLastTimeExample 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByExample(UserLastTimeExample userLastTimeExample);

    /**
     * 此方法对应数据库表user_last_time用于删除操作（本系统数据库删除操作非物理删除，请慎用）
     * @param primaryKey 删除条件
     * @return true-物理删除数据成功 false-物理删除数据失败
     */
    public boolean physicalDeleteByPrimaryKey(String primaryKey);

    /**
     * 此方法对应数据库表user_last_time用于往表中添加数据
     * @param userLastTime 插入数据
     * @return true-添加数据成功 false-添加数据失败
     */
    public boolean insertSelective(UserLastTime userLastTime);

    /**
     * 此方法对应数据库表user_last_time用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param userLastTime 更新数据
     * @param userLastTimeExample 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByExampleSelective(UserLastTime userLastTime, UserLastTimeExample userLastTimeExample);

    /**
     * 此方法对应数据库表user_last_time用于更新数据，其中 create_time不提供修改功能， c_time_stamp自动设置为当前数据库时间
     * @param userLastTime 更新条件
     * @return true-更新数据成功 false-更新数据失败
     */
    public boolean updateByPrimaryKeySelective(UserLastTime userLastTime);

}
