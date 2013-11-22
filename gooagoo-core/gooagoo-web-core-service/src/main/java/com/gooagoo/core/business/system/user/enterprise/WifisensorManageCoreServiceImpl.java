package com.gooagoo.core.business.system.user.enterprise;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.user.enterprise.WifisensorManageCoreService;
import com.gooagoo.api.generator.core.shop.DeviceWifisensorGeneratorCoreService;
import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;

@Service
public class WifisensorManageCoreServiceImpl implements WifisensorManageCoreService

{

    @Autowired
    private DeviceWifisensorGeneratorCoreService deviceWifisensorGeneratorCoreService;

    @Override
    public boolean addWifisensor(DeviceWifisensor deviceWifisensor) throws Exception
    {
        deviceWifisensor.setIsDel("N");
        return this.deviceWifisensorGeneratorCoreService.insertSelective(deviceWifisensor);
    }

    @Override
    public boolean updateWifisensor(DeviceWifisensor deviceWifisensor) throws Exception
    {
        return this.deviceWifisensorGeneratorCoreService.updateByPrimaryKeySelective(deviceWifisensor);
    }

    @Override
    public boolean delWifisensor(String deviceWifisensorIds) throws Exception
    {
        List<String> idList = Arrays.asList(deviceWifisensorIds.split(","));
        DeviceWifisensorExample deviceWifisensorExample = new DeviceWifisensorExample();
        deviceWifisensorExample.createCriteria().andDeviceWifisensorIdIn(idList).andIsDelEqualTo("N");
        DeviceWifisensor deviceWifisensor = new DeviceWifisensor();
        deviceWifisensor.setIsDel("Y");
        return this.deviceWifisensorGeneratorCoreService.updateByExampleSelective(deviceWifisensor, deviceWifisensorExample);
    }

}
