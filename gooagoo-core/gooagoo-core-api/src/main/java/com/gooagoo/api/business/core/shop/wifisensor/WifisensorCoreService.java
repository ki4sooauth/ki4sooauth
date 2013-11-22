package com.gooagoo.api.business.core.shop.wifisensor;

import com.gooagoo.entity.generator.shop.DeviceWifisensor;

/**
 * 
 *wifisensor设备管理
 *
 */
public interface WifisensorCoreService
{

    /**
     * 新增wifisensor设备
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean addWifisensor(DeviceWifisensor wifiinfo) throws Exception;

    /**
     * 编辑wifisensor设备
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean updateWifisensor(DeviceWifisensor wifisensor) throws Exception;

    /**
     * 删除wifisensor设备
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean deleteWifisensor(String wifiInfoId) throws Exception;

    /**
     * 批量删除wifisensor设备
     * @param wifiInfoIds 多个用逗号分隔
     * @return
     * @throws Exception
     */
    public boolean batchDeleteWifisensor(String wifiInfoIds) throws Exception;

}
