package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ServiceToolSort;
import com.gooagoo.entity.generator.shop.ServiceToolSortExample;
import com.gooagoo.entity.generator.shop.ServiceToolSortKey;

public interface ServiceToolSortMapper
{

    public Integer countByExample(ServiceToolSortExample serviceToolSortExample);

    public List<ServiceToolSort> selectByExample(ServiceToolSortExample serviceToolSortExample);

    public ServiceToolSort selectByPrimaryKey(ServiceToolSortKey serviceToolSortKey);

    public Integer deleteByExample(ServiceToolSortExample serviceToolSortExample);

    public Integer deleteByPrimaryKey(ServiceToolSortKey serviceToolSortKey);

    public Integer insertSelective(ServiceToolSort serviceToolSort);

    public Integer updateAllByExample(@Param("record") ServiceToolSort serviceToolSort, @Param("example") ServiceToolSortExample serviceToolSortExample);

    public Integer updateByExampleSelective(@Param("record") ServiceToolSort serviceToolSort, @Param("example") ServiceToolSortExample serviceToolSortExample);

    public Integer updateByPrimaryKeySelective(ServiceToolSort serviceToolSort);

}
