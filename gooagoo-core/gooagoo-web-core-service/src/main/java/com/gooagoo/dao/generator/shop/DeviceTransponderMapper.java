package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceTransponderExample;
import com.gooagoo.entity.generator.shop.DeviceTransponderKey;

public interface DeviceTransponderMapper
{

    public Integer countByExample(DeviceTransponderExample deviceTransponderExample);

    public List<DeviceTransponder> selectByExample(DeviceTransponderExample deviceTransponderExample);

    public DeviceTransponder selectByPrimaryKey(DeviceTransponderKey deviceTransponderKey);

    public Integer deleteByExample(DeviceTransponderExample deviceTransponderExample);

    public Integer deleteByPrimaryKey(DeviceTransponderKey deviceTransponderKey);

    public Integer insertSelective(DeviceTransponder deviceTransponder);

    public Integer updateAllByExample(@Param("record") DeviceTransponder deviceTransponder, @Param("example") DeviceTransponderExample deviceTransponderExample);

    public Integer updateByExampleSelective(@Param("record") DeviceTransponder deviceTransponder, @Param("example") DeviceTransponderExample deviceTransponderExample);

    public Integer updateByPrimaryKeySelective(DeviceTransponder deviceTransponder);

}
