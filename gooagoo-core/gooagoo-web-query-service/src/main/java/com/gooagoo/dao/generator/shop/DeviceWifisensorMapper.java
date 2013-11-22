package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;
import com.gooagoo.entity.generator.shop.DeviceWifisensorKey;

public interface DeviceWifisensorMapper
{

    public Integer countByExample(DeviceWifisensorExample deviceWifisensorExample);

    public List<DeviceWifisensor> selectByExample(DeviceWifisensorExample deviceWifisensorExample);

    public DeviceWifisensor selectByPrimaryKey(DeviceWifisensorKey deviceWifisensorKey);

}
