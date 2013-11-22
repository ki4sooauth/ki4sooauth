package com.gooagoo.trans.api;

import com.gooagoo.trans.entity.gtsa01.transform.SystemConfigurationRoot;

/**
 * 系统配置
 */
public interface SysConfigurationTransService
{
    /**
     * 接口gtsa01:系统初始化配置
     * @param mac 转发器mac地址
     * @return
     * @throws Exception
     */
    public SystemConfigurationRoot getSysConfigurationInfo(String mac) throws Exception;
}
