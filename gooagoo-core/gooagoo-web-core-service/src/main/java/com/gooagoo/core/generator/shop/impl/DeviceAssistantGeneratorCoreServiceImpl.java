package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.DeviceAssistantGeneratorCoreService;
import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;
import com.gooagoo.entity.generator.shop.DeviceAssistantKey;
import com.gooagoo.dao.generator.shop.DeviceAssistantMapper;

@Service
public class DeviceAssistantGeneratorCoreServiceImpl implements DeviceAssistantGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(DeviceAssistantExample deviceAssistantExample) 
    {
        return this.deviceAssistantMapper.deleteByExample(deviceAssistantExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        DeviceAssistantKey deviceAssistantKey = new DeviceAssistantKey();
        deviceAssistantKey.setDeviceAssistantId(primaryKey);
        return this.deviceAssistantMapper.deleteByPrimaryKey(deviceAssistantKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(DeviceAssistantExample deviceAssistantExample) 
    {
        DeviceAssistant deviceAssistant = new DeviceAssistant();
        deviceAssistant.setIsDel("Y");
        return this.deviceAssistantMapper.updateByExampleSelective(deviceAssistant,deviceAssistantExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        DeviceAssistant deviceAssistant = new DeviceAssistant();
        deviceAssistant.setDeviceAssistantId(primaryKey);
        deviceAssistant.setIsDel("Y");
        return this.deviceAssistantMapper.updateByPrimaryKeySelective(deviceAssistant) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(DeviceAssistant deviceAssistant) 
    {
        return this.deviceAssistantMapper.insertSelective(deviceAssistant) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(DeviceAssistant deviceAssistant,DeviceAssistantExample deviceAssistantExample) 
    {
        return this.deviceAssistantMapper.updateByExampleSelective(deviceAssistant,deviceAssistantExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(DeviceAssistant deviceAssistant) 
    {
        return this.deviceAssistantMapper.updateByPrimaryKeySelective(deviceAssistant) > 0 ? true : false;
    }

}
