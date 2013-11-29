package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.DeviceTransponderGeneratorCoreService;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.entity.generator.shop.DeviceTransponderKey;
import com.gooagoo.dao.generator.shop.DeviceTransponderMapper;

@Service
public class DeviceTransponderGeneratorCoreServiceImpl implements DeviceTransponderGeneratorCoreService
{

    @Autowired
    private DeviceTransponderMapper deviceTransponderMapper;

    @Override
    public Integer countByExample(DeviceTransponderExample deviceTransponderExample) 
    {
        return this.deviceTransponderMapper.countByExample(deviceTransponderExample);
    }

    @Override
    public List<DeviceTransponder> selectByExample(DeviceTransponderExample deviceTransponderExample) 
    {
        return this.deviceTransponderMapper.selectByExample(deviceTransponderExample);
    }

    @Override
    public DeviceTransponder selectUnDelByPrimaryKey(String primaryKey) 
    {
        DeviceTransponderKey deviceTransponderKey = new DeviceTransponderKey();
        deviceTransponderKey.setIsDel("N");
        deviceTransponderKey.setDeviceTransponderId(primaryKey);
        return this.deviceTransponderMapper.selectByPrimaryKey(deviceTransponderKey);
    }

    @Override
    public DeviceTransponder selectByPrimaryKey(String primaryKey) 
    {
        DeviceTransponderKey deviceTransponderKey = new DeviceTransponderKey();
        deviceTransponderKey.setDeviceTransponderId(primaryKey);
        return this.deviceTransponderMapper.selectByPrimaryKey(deviceTransponderKey);
    }

    @Override
    public boolean physicalDeleteByExample(DeviceTransponderExample deviceTransponderExample) 
    {
        return this.deviceTransponderMapper.deleteByExample(deviceTransponderExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        DeviceTransponderKey deviceTransponderKey = new DeviceTransponderKey();
        deviceTransponderKey.setDeviceTransponderId(primaryKey);
        return this.deviceTransponderMapper.deleteByPrimaryKey(deviceTransponderKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(DeviceTransponderExample deviceTransponderExample) 
    {
        DeviceTransponder deviceTransponder = new DeviceTransponder();
        deviceTransponder.setIsDel("Y");
        return this.deviceTransponderMapper.updateByExampleSelective(deviceTransponder,deviceTransponderExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        DeviceTransponder deviceTransponder = new DeviceTransponder();
        deviceTransponder.setDeviceTransponderId(primaryKey);
        deviceTransponder.setIsDel("Y");
        return this.deviceTransponderMapper.updateByPrimaryKeySelective(deviceTransponder) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(DeviceTransponder deviceTransponder) 
    {
        return this.deviceTransponderMapper.insertSelective(deviceTransponder) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(DeviceTransponder deviceTransponder,DeviceTransponderExample deviceTransponderExample) 
    {
        return this.deviceTransponderMapper.updateByExampleSelective(deviceTransponder,deviceTransponderExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(DeviceTransponder deviceTransponder) 
    {
        return this.deviceTransponderMapper.updateByPrimaryKeySelective(deviceTransponder) > 0 ? true : false;
    }

}
