package com.gooagoo.core.business.shop.wifisensor;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.wifisensor.WifisensorCoreService;
import com.gooagoo.api.generator.core.shop.DeviceWifisensorGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;

@Service
public class WifisensorCoreServiceImpl implements WifisensorCoreService
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
    public boolean deleteWifisensor(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除商家Wifisensor信息：Id为空");
            return false;
        }
        return this.deviceWifisensorGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteWifisensor(String wifiInfoIds) throws Exception
    {
        if (!StringUtils.hasText(wifiInfoIds))
        {
            return false;
        }
        List<String> wifiInfoIdList = Arrays.asList(wifiInfoIds.split(","));
        DeviceWifisensorExample deviceWifisensorExample = new DeviceWifisensorExample();
        deviceWifisensorExample.createCriteria().andDeviceWifisensorIdIn(wifiInfoIdList);
        return this.deviceWifisensorGeneratorCoreService.deleteByExample(deviceWifisensorExample);
    }
}
