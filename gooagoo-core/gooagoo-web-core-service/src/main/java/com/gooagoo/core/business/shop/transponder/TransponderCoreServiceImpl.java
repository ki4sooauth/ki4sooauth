package com.gooagoo.core.business.shop.transponder;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.transponder.TransponderCoreService;
import com.gooagoo.api.generator.core.shop.DeviceTransponderGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;

@Service
public class TransponderCoreServiceImpl implements TransponderCoreService
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
    public boolean deleteTransponder(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除转发器设备：Id为空");
            return false;
        }
        return this.deviceTransponderGeneratorCoreService.deleteByPrimaryKey(id);
    }

    @Override
    public boolean batchDeleteTransponder(String transponderIds) throws Exception
    {
        if (!StringUtils.hasText(transponderIds))
        {
            return false;
        }
        List<String> transponderIdList = Arrays.asList(transponderIds.split(","));
        DeviceTransponderExample deviceTransponderExample = new DeviceTransponderExample();
        deviceTransponderExample.createCriteria().andDeviceTransponderIdIn(transponderIdList);
        return this.deviceTransponderGeneratorCoreService.deleteByExample(deviceTransponderExample);
    }

}
