package com.gooagoo.api.generator.query.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysRoleAuthority;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityExample;

public interface SysRoleAuthorityGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_role_authority用于查询表中对应数据条数
     * @param sysRoleAuthorityExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(SysRoleAuthorityExample sysRoleAuthorityExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_role_authority用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param sysRoleAuthorityExample 查询条件
     * @return 
     */
    public List<SysRoleAuthority> selectByExample(SysRoleAuthorityExample sysRoleAuthorityExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_role_authority用于查询数据
     * @param sysRoleAuthorityKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public SysRoleAuthority selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_role_authority用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public SysRoleAuthority selectByPrimaryKey(String primaryKey) ;

}