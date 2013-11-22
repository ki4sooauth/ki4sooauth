package com.gooagoo.core.business.system.user.enterprise;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.user.enterprise.TransponderManageCoreService;
import com.gooagoo.api.generator.core.shop.DeviceTransponderGeneratorCoreService;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;

@Service
public class TransponderManageCoreServiceImpl implements TransponderManageCoreService
{

    @Autowired
    private DeviceTransponderGeneratorCoreService deviceTransponderGeneratorCoreService;

    @Override
    public boolean addTransponder(DeviceTransponder deviceTransponder) throws Exception
    {
        deviceTransponder.setIsDel("N");
        return this.deviceTransponderGeneratorCoreService.insertSelective(deviceTransponder);
    }

    @Override
    public boolean updateTransponder(DeviceTransponder deviceTransponder) throws Exception
    {
        return this.deviceTransponderGeneratorCoreService.updateByPrimaryKeySelective(deviceTransponder);
    }

    @Override
    public boolean delTransponder(String deviceTransponderIds) throws Exception
    {
        List<String> deviceTransponderIdList = Arrays.asList(deviceTransponderIds.split(","));
        DeviceTransponder deviceTransponder = new DeviceTransponder();
        deviceTransponder.setIsDel("Y");
        DeviceTransponderExample deviceTransponderExample = new DeviceTransponderExample();
        deviceTransponderExample.createCriteria().andDeviceTransponderIdIn(deviceTransponderIdList).andIsDelEqualTo("N");
        return this.deviceTransponderGeneratorCoreService.updateByExampleSelective(deviceTransponder, deviceTransponderExample);
    }
}
