package com.gooagoo.api.generator.query.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;

public interface DeviceAssistantGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表device_assistant用于查询表中对应数据条数
     * @param deviceAssistantExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(DeviceAssistantExample deviceAssistantExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表device_assistant用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param deviceAssistantExample 查询条件
     * @return 
     */
    public List<DeviceAssistant> selectByExample(DeviceAssistantExample deviceAssistantExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表device_assistant用于查询数据
     * @param deviceAssistantKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public DeviceAssistant selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表device_assistant用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public DeviceAssistant selectByPrimaryKey(String primaryKey) ;

}
