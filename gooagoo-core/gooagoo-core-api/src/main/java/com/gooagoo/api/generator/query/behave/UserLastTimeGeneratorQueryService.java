package com.gooagoo.api.generator.query.behave;

import java.util.List;

import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;

public interface UserLastTimeGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_last_time用于查询表中对应数据条数
     * @param userLastTimeExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(UserLastTimeExample userLastTimeExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_last_time用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param userLastTimeExample 查询条件
     * @return 
     */
    public List<UserLastTime> selectByExample(UserLastTimeExample userLastTimeExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表user_last_time用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public UserLastTime selectByPrimaryKey(String primaryKey) ;

}
