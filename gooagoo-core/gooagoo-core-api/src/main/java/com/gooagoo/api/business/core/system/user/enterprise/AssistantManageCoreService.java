package com.gooagoo.api.business.core.system.user.enterprise;

import com.gooagoo.entity.generator.shop.DeviceAssistant;

/**
 * 店员助理管理
 */
public interface AssistantManageCoreService

{

    /**
     * 新增店员助理
     * @param deviceAssistant
     * @return
     * @throws Exception
     */
    public boolean addAssistant(DeviceAssistant deviceAssistant) throws Exception;

    /**
     * 编辑店员助理
     * @param deviceAssistant
     * @return
     * @throws Exception
     */
    public boolean updateAssistant(DeviceAssistant deviceAssistant) throws Exception;

    /**
     * 删除店员助理
     * @param deviceAssistantIds(多个用逗号分隔)
     * @return
     * @throws Exception
     */
    public boolean delAssistant(String deviceAssistantId) throws Exception;

}
