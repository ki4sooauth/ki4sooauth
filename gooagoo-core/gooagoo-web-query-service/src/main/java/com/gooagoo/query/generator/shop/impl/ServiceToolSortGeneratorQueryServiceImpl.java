package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ServiceToolSortGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ServiceToolSort;
import com.gooagoo.entity.generator.shop.ServiceToolSortExample;
import com.gooagoo.entity.generator.shop.ServiceToolSortKey;
import com.gooagoo.dao.generator.shop.ServiceToolSortMapper;

@Service
public class ServiceToolSortGeneratorQueryServiceImpl implements ServiceToolSortGeneratorQueryService
{

    @Autowired
    private ServiceToolSortMapper serviceToolSortMapper;

    @Override
    public Integer countByExample(ServiceToolSortExample serviceToolSortExample) 
    {
        return this.serviceToolSortMapper.countByExample(serviceToolSortExample);
    }

    @Override
    public List<ServiceToolSort> selectByExample(ServiceToolSortExample serviceToolSortExample) 
    {
        return this.serviceToolSortMapper.selectByExample(serviceToolSortExample);
    }

    @Override
    public ServiceToolSort selectByPrimaryKey(String primaryKey) 
    {
        ServiceToolSortKey serviceToolSortKey = new ServiceToolSortKey();
        serviceToolSortKey.setId(primaryKey);
        return this.serviceToolSortMapper.selectByPrimaryKey(serviceToolSortKey);
    }

}
