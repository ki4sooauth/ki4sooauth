package com.gooagoo.api.business.core.shop.transponder;

import com.gooagoo.entity.generator.shop.DeviceTransponder;

/*
 * 转发器设备管理
 */
public interface TransponderCoreService
{

    /**
     * 新增转发器设备
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean addTransponder(DeviceTransponder transponder) throws Exception;

    /**
     * 编辑转发器设备
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean updateTransponder(DeviceTransponder transponder) throws Exception;

    /**
     * 删除转发器设备
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean deleteTransponder(String transponderId) throws Exception;

    /**
     * 批量删除转发器设备
     * @param transponderIds 多个用逗号分隔
     * @return
     * @throws Exception
     */
    public boolean batchDeleteTransponder(String transponderIds) throws Exception;

}
