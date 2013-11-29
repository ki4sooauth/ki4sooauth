package com.gooagoo.core.business.system.user.enterprise;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.user.enterprise.AssistantManageCoreService;
import com.gooagoo.api.generator.core.shop.DeviceAssistantGeneratorCoreService;
import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;

@Service
public class AssistantManageCoreServiceImpl implements AssistantManageCoreService

{

    @Autowired
    private DeviceAssistantGeneratorCoreService deviceAssistantGeneratorCoreService;

    @Override
    public boolean addAssistant(DeviceAssistant deviceAssistant) throws Exception
    {
        deviceAssistant.setIsDel("N");
        return this.deviceAssistantGeneratorCoreService.insertSelective(deviceAssistant);
    }

    @Override
    public boolean updateAssistant(DeviceAssistant deviceAssistant) throws Exception
    {
        return this.deviceAssistantGeneratorCoreService.updateByPrimaryKeySelective(deviceAssistant);
    }

    @Override
    public boolean delAssistant(String deviceAssistantIds) throws Exception
    {
        List<String> idList = Arrays.asList(deviceAssistantIds.split(","));
        DeviceAssistantExample deviceAssistantExample = new DeviceAssistantExample();
        deviceAssistantExample.createCriteria().andDeviceAssistantIdIn(idList).andIsDelEqualTo("N");
        DeviceAssistant deviceAssistant = new DeviceAssistant();
        deviceAssistant.setIsDel("Y");
        return this.deviceAssistantGeneratorCoreService.updateByExampleSelective(deviceAssistant, deviceAssistantExample);
    }

}
