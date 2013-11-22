package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.DeviceWifisensorGeneratorCoreService;
import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;
import com.gooagoo.entity.generator.shop.DeviceWifisensorKey;
import com.gooagoo.dao.generator.shop.DeviceWifisensorMapper;

@Service
public class DeviceWifisensorGeneratorCoreServiceImpl implements DeviceWifisensorGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(DeviceWifisensorExample deviceWifisensorExample) 
    {
        return this.deviceWifisensorMapper.deleteByExample(deviceWifisensorExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        DeviceWifisensorKey deviceWifisensorKey = new DeviceWifisensorKey();
        deviceWifisensorKey.setDeviceWifisensorId(primaryKey);
        return this.deviceWifisensorMapper.deleteByPrimaryKey(deviceWifisensorKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(DeviceWifisensorExample deviceWifisensorExample) 
    {
        DeviceWifisensor deviceWifisensor = new DeviceWifisensor();
        deviceWifisensor.setIsDel("Y");
        return this.deviceWifisensorMapper.updateByExampleSelective(deviceWifisensor,deviceWifisensorExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        DeviceWifisensor deviceWifisensor = new DeviceWifisensor();
        deviceWifisensor.setDeviceWifisensorId(primaryKey);
        deviceWifisensor.setIsDel("Y");
        return this.deviceWifisensorMapper.updateByPrimaryKeySelective(deviceWifisensor) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(DeviceWifisensor deviceWifisensor) 
    {
        return this.deviceWifisensorMapper.insertSelective(deviceWifisensor) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(DeviceWifisensor deviceWifisensor,DeviceWifisensorExample deviceWifisensorExample) 
    {
        return this.deviceWifisensorMapper.updateByExampleSelective(deviceWifisensor,deviceWifisensorExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(DeviceWifisensor deviceWifisensor) 
    {
        return this.deviceWifisensorMapper.updateByPrimaryKeySelective(deviceWifisensor) > 0 ? true : false;
    }

}
