package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.DeviceWifisensorGeneratorQueryService;
import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;
import com.gooagoo.entity.generator.shop.DeviceWifisensorKey;
import com.gooagoo.dao.generator.shop.DeviceWifisensorMapper;

@Service
public class DeviceWifisensorGeneratorQueryServiceImpl implements DeviceWifisensorGeneratorQueryService
{

    @Autowired
    private DeviceWifisensorMapper deviceWifisensorMapper;

    @Override
    public Integer countByExample(DeviceWifisensorExample deviceWifisensorExample) 
    {
        return this.deviceWifisensorMapper.countByExample(deviceWifisensorExample);
    }

    @Override
    public List<DeviceWifisensor> selectByExample(DeviceWifisensorExample deviceWifisensorExample) 
    {
        return this.deviceWifisensorMapper.selectByExample(deviceWifisensorExample);
    }

    @Override
    public DeviceWifisensor selectUnDelByPrimaryKey(String primaryKey) 
    {
        DeviceWifisensorKey deviceWifisensorKey = new DeviceWifisensorKey();
        deviceWifisensorKey.setIsDel("N");
        deviceWifisensorKey.setDeviceWifisensorId(primaryKey);
        return this.deviceWifisensorMapper.selectByPrimaryKey(deviceWifisensorKey);
    }

    @Override
    public DeviceWifisensor selectByPrimaryKey(String primaryKey) 
    {
        DeviceWifisensorKey deviceWifisensorKey = new DeviceWifisensorKey();
        deviceWifisensorKey.setDeviceWifisensorId(primaryKey);
        return this.deviceWifisensorMapper.selectByPrimaryKey(deviceWifisensorKey);
    }

}
