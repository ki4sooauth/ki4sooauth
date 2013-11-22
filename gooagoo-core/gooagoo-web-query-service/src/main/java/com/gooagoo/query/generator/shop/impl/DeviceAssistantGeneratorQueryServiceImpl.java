package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.DeviceAssistantGeneratorQueryService;
import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;
import com.gooagoo.entity.generator.shop.DeviceAssistantKey;
import com.gooagoo.dao.generator.shop.DeviceAssistantMapper;

@Service
public class DeviceAssistantGeneratorQueryServiceImpl implements DeviceAssistantGeneratorQueryService
{

    @Autowired
    private DeviceAssistantMapper deviceAssistantMapper;

    @Override
    public Integer countByExample(DeviceAssistantExample deviceAssistantExample) 
    {
        return this.deviceAssistantMapper.countByExample(deviceAssistantExample);
    }

    @Override
    public List<DeviceAssistant> selectByExample(DeviceAssistantExample deviceAssistantExample) 
    {
        return this.deviceAssistantMapper.selectByExample(deviceAssistantExample);
    }

    @Override
    public DeviceAssistant selectUnDelByPrimaryKey(String primaryKey) 
    {
        DeviceAssistantKey deviceAssistantKey = new DeviceAssistantKey();
        deviceAssistantKey.setIsDel("N");
        deviceAssistantKey.setDeviceAssistantId(primaryKey);
        return this.deviceAssistantMapper.selectByPrimaryKey(deviceAssistantKey);
    }

    @Override
    public DeviceAssistant selectByPrimaryKey(String primaryKey) 
    {
        DeviceAssistantKey deviceAssistantKey = new DeviceAssistantKey();
        deviceAssistantKey.setDeviceAssistantId(primaryKey);
        return this.deviceAssistantMapper.selectByPrimaryKey(deviceAssistantKey);
    }

}
