package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ServiceToolSortGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ServiceToolSort;
import com.gooagoo.entity.generator.shop.ServiceToolSortExample;
import com.gooagoo.entity.generator.shop.ServiceToolSortKey;
import com.gooagoo.dao.generator.shop.ServiceToolSortMapper;

@Service
public class ServiceToolSortGeneratorCoreServiceImpl implements ServiceToolSortGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ServiceToolSortExample serviceToolSortExample) 
    {
        return this.serviceToolSortMapper.deleteByExample(serviceToolSortExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ServiceToolSortKey serviceToolSortKey = new ServiceToolSortKey();
        serviceToolSortKey.setId(primaryKey);
        return this.serviceToolSortMapper.deleteByPrimaryKey(serviceToolSortKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ServiceToolSort serviceToolSort) 
    {
        return this.serviceToolSortMapper.insertSelective(serviceToolSort) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ServiceToolSort serviceToolSort,ServiceToolSortExample serviceToolSortExample) 
    {
        return this.serviceToolSortMapper.updateByExampleSelective(serviceToolSort,serviceToolSortExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ServiceToolSort serviceToolSort) 
    {
        return this.serviceToolSortMapper.updateByPrimaryKeySelective(serviceToolSort) > 0 ? true : false;
    }

}
