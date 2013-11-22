package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ServiceToolSort;
import com.gooagoo.entity.generator.shop.ServiceToolSortExample;
import com.gooagoo.entity.generator.shop.ServiceToolSortKey;

public interface ServiceToolSortMapper
{

    public Integer countByExample(ServiceToolSortExample serviceToolSortExample);

    public List<ServiceToolSort> selectByExample(ServiceToolSortExample serviceToolSortExample);

    public ServiceToolSort selectByPrimaryKey(ServiceToolSortKey serviceToolSortKey);

}
