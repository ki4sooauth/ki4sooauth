package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.DeviceTransponderGeneratorQueryService;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.entity.generator.shop.DeviceTransponderKey;
import com.gooagoo.dao.generator.shop.DeviceTransponderMapper;

@Service
public class DeviceTransponderGeneratorQueryServiceImpl implements DeviceTransponderGeneratorQueryService
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

}
