package com.gooagoo.core.business.shop.assistant;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.assistant.AssistantCoreService;
import com.gooagoo.api.generator.core.shop.DeviceAssistantGeneratorCoreService;
import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;

@Service
public class AssistantCoreServiceImpl implements AssistantCoreService
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
    public boolean deleteAssistant(String deviceAssistantId) throws Exception
    {
        DeviceAssistant deviceAssistant = new DeviceAssistant();
        deviceAssistant.setIsDel("Y");
        DeviceAssistantExample deviceAssistantExample = new DeviceAssistantExample();
        deviceAssistantExample.createCriteria().andDeviceAssistantIdEqualTo(deviceAssistantId);
        return this.deviceAssistantGeneratorCoreService.updateByExampleSelective(deviceAssistant, deviceAssistantExample);
    }

    @Override
    public boolean batchDeleteAssistant(String deviceAssistantIds) throws Exception
    {
        if (!StringUtils.hasText(deviceAssistantIds))
        {
            return false;
        }
        List<String> assistantIdList = Arrays.asList(deviceAssistantIds.split(","));
        DeviceAssistantExample deviceAssistantExample = new DeviceAssistantExample();
        deviceAssistantExample.createCriteria().andDeviceAssistantIdIn(assistantIdList);
        return this.deviceAssistantGeneratorCoreService.deleteByExample(deviceAssistantExample);
    }

}
