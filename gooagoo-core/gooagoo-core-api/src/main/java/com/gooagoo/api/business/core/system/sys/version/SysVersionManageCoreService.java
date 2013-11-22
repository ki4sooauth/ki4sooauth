package com.gooagoo.api.business.core.system.sys.version;

import com.gooagoo.entity.generator.sys.MobileVersion;

/**
 *  移动设备版本管理
 */
public interface SysVersionManageCoreService
{

    /**
     * 新增移动设备版本
     * @param MobileVersion mobileVersion
     * @return
     * @throws Exception
     */
    public boolean addSysMobileVersion(MobileVersion mobileVersion) throws Exception;

}
