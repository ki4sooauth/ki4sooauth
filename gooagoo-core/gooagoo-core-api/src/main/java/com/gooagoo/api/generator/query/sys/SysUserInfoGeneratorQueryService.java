package com.gooagoo.api.generator.query.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysUserInfo;
import com.gooagoo.entity.generator.sys.SysUserInfoExample;

public interface SysUserInfoGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_user_info用于查询表中对应数据条数
     * @param sysUserInfoExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(SysUserInfoExample sysUserInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_user_info用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param sysUserInfoExample 查询条件
     * @return 
     */
    public List<SysUserInfo> selectByExample(SysUserInfoExample sysUserInfoExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_user_info用于查询数据
     * @param sysUserInfoKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public SysUserInfo selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_user_info用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public SysUserInfo selectByPrimaryKey(String primaryKey) ;

}
