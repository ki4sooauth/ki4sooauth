package com.gooagoo.api.business.core.shop.assistant;

import com.gooagoo.entity.generator.shop.DeviceAssistant;

/**
 *  店员助理设备管理  
 * @author Administrator
 *
 */
public interface AssistantCoreService
{

    /**
     * 新增店员助理设备
     * @param DeviceAssistant
     * @return
     * @throws Exception
     */
    public boolean addAssistant(DeviceAssistant deviceAssistant) throws Exception;

    /**
     * 编辑店员助理设备
     * @param DeviceAssistant
     * @return
     * @throws Exception
     */
    public boolean updateAssistant(DeviceAssistant deviceAssistant) throws Exception;

    /**
     * 删除店员助理设备(软删)
     * @param deviceAssistantId
     * @return
     * @throws Exception
     */
    public boolean deleteAssistant(String deviceAssistantId) throws Exception;

    /**
     * 批量删除店员助理设备(硬删)
     * @param deviceAssistantIds 多个用逗号分隔
     * @return
     * @throws Exception
     */
    public boolean batchDeleteAssistant(String deviceAssistantIds) throws Exception;

}
