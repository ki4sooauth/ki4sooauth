package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.entity.generator.shop.DeviceTransponderKey;

public interface DeviceTransponderMapper
{

    public Integer countByExample(DeviceTransponderExample deviceTransponderExample);

    public List<DeviceTransponder> selectByExample(DeviceTransponderExample deviceTransponderExample);

    public DeviceTransponder selectByPrimaryKey(DeviceTransponderKey deviceTransponderKey);

}
