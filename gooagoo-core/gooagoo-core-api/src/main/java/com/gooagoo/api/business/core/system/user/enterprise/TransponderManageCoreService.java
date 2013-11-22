package com.gooagoo.api.business.core.system.user.enterprise;

import com.gooagoo.entity.generator.shop.DeviceTransponder;

/**
 *  转发器管理
 */
public interface TransponderManageCoreService

{

    /**
     * 新增转发器
     * @param deviceTransponder
     * @return
     * @throws Exception
     */
    public boolean addTransponder(DeviceTransponder deviceTransponder) throws Exception;

    /**
     * 编辑转发器
     * @param deviceTransponder
     * @return
     * @throws Exception
     */
    public boolean updateTransponder(DeviceTransponder deviceTransponder) throws Exception;

    /**
     * 删除转发器
     * @param deviceTransponderIds(多个逗号分隔)
     * @return
     * @throws Exception
     */
    public boolean delTransponder(String deviceTransponderIds) throws Exception;

}
