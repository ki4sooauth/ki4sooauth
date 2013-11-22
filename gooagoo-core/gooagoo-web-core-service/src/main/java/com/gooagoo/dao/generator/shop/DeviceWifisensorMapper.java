package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.DeviceWifisensorExample;
import com.gooagoo.entity.generator.shop.DeviceWifisensorKey;

public interface DeviceWifisensorMapper
{

    public Integer countByExample(DeviceWifisensorExample deviceWifisensorExample);

    public List<DeviceWifisensor> selectByExample(DeviceWifisensorExample deviceWifisensorExample);

    public DeviceWifisensor selectByPrimaryKey(DeviceWifisensorKey deviceWifisensorKey);

    public Integer deleteByExample(DeviceWifisensorExample deviceWifisensorExample);

    public Integer deleteByPrimaryKey(DeviceWifisensorKey deviceWifisensorKey);

    public Integer insertSelective(DeviceWifisensor deviceWifisensor);

    public Integer updateAllByExample(@Param("record") DeviceWifisensor deviceWifisensor, @Param("example") DeviceWifisensorExample deviceWifisensorExample);

    public Integer updateByExampleSelective(@Param("record") DeviceWifisensor deviceWifisensor, @Param("example") DeviceWifisensorExample deviceWifisensorExample);

    public Integer updateByPrimaryKeySelective(DeviceWifisensor deviceWifisensor);

}
