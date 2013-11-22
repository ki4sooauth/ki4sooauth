package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysAuthority;

/**
 *  后台管理权限表管理
 */
public interface SysAuthorityDicCoreService

{

    /**
     * 新增后台管理权限
     * @param sysAuthority
     * @return
     * @throws Exception
     */
    public boolean addSysAuthorityDic(SysAuthority sysAuthority) throws Exception;

    /**
     * 编辑后台管理权限
     * @param sysAuthority
     * @return
     * @throws Exception
     */
    public boolean updateSysAuthorityDic(SysAuthority sysAuthority) throws Exception;

    /**
     * 删除后台管理权限
     * @param authorityId
     * @return
     * @throws Exception
     */
    public boolean delSysAuthorityDic(String authorityId) throws Exception;

    /**
     * 批量新增后台管理权限（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllSysAuthorityDic(List<SysAuthority> sysList) throws Exception;

}
