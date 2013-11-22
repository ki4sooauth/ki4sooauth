package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;
import com.gooagoo.entity.generator.shop.DeviceAssistantKey;

public interface DeviceAssistantMapper
{

    public Integer countByExample(DeviceAssistantExample deviceAssistantExample);

    public List<DeviceAssistant> selectByExample(DeviceAssistantExample deviceAssistantExample);

    public DeviceAssistant selectByPrimaryKey(DeviceAssistantKey deviceAssistantKey);

    public Integer deleteByExample(DeviceAssistantExample deviceAssistantExample);

    public Integer deleteByPrimaryKey(DeviceAssistantKey deviceAssistantKey);

    public Integer insertSelective(DeviceAssistant deviceAssistant);

    public Integer updateAllByExample(@Param("record") DeviceAssistant deviceAssistant, @Param("example") DeviceAssistantExample deviceAssistantExample);

    public Integer updateByExampleSelective(@Param("record") DeviceAssistant deviceAssistant, @Param("example") DeviceAssistantExample deviceAssistantExample);

    public Integer updateByPrimaryKeySelective(DeviceAssistant deviceAssistant);

}
