package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;
import com.gooagoo.entity.generator.shop.DeviceAssistantKey;

public interface DeviceAssistantMapper
{

    public Integer countByExample(DeviceAssistantExample deviceAssistantExample);

    public List<DeviceAssistant> selectByExample(DeviceAssistantExample deviceAssistantExample);

    public DeviceAssistant selectByPrimaryKey(DeviceAssistantKey deviceAssistantKey);

}
