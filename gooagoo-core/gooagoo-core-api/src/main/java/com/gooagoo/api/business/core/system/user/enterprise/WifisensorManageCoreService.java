package com.gooagoo.api.business.core.system.user.enterprise;

import com.gooagoo.entity.generator.shop.DeviceWifisensor;

/**
 *  wifisensor管理
 */
public interface WifisensorManageCoreService
{

    /**
     * 新增wifisensor
     * @param deviceWifisensor
     * @return
     * @throws Exception
     */
    public boolean addWifisensor(DeviceWifisensor deviceWifisensor) throws Exception;

    /**
     * 编辑wifisensor
     * @param deviceWifisensor
     * @return
     * @throws Exception
     */
    public boolean updateWifisensor(DeviceWifisensor deviceWifisensor) throws Exception;

    /**
     * 删除wifisensor
     * @param deviceWifisensorIds(多个用逗号分隔)
     * @return
     * @throws Exception
     */
    public boolean delWifisensor(String deviceWifisensorIds) throws Exception;

}
