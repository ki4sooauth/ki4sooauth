package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.PlatformRegionGeneratorCoreService;
import com.gooagoo.entity.generator.sys.PlatformRegion;
import com.gooagoo.entity.generator.sys.PlatformRegionExample;
import com.gooagoo.entity.generator.sys.PlatformRegionKey;
import com.gooagoo.dao.generator.sys.PlatformRegionMapper;

@Service
public class PlatformRegionGeneratorCoreServiceImpl implements PlatformRegionGeneratorCoreService
{

    @Autowired
    private PlatformRegionMapper platformRegionMapper;

    @Override
    public Integer countByExample(PlatformRegionExample platformRegionExample) 
    {
        return this.platformRegionMapper.countByExample(platformRegionExample);
    }

    @Override
    public List<PlatformRegion> selectByExample(PlatformRegionExample platformRegionExample) 
    {
        return this.platformRegionMapper.selectByExample(platformRegionExample);
    }

    @Override
    public PlatformRegion selectUnDelByPrimaryKey(String primaryKey) 
    {
        PlatformRegionKey platformRegionKey = new PlatformRegionKey();
        platformRegionKey.setIsDel("N");
        platformRegionKey.setPlatformId(primaryKey);
        return this.platformRegionMapper.selectByPrimaryKey(platformRegionKey);
    }

    @Override
    public PlatformRegion selectByPrimaryKey(String primaryKey) 
    {
        PlatformRegionKey platformRegionKey = new PlatformRegionKey();
        platformRegionKey.setPlatformId(primaryKey);
        return this.platformRegionMapper.selectByPrimaryKey(platformRegionKey);
    }

    @Override
    public boolean physicalDeleteByExample(PlatformRegionExample platformRegionExample) 
    {
        return this.platformRegionMapper.deleteByExample(platformRegionExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        PlatformRegionKey platformRegionKey = new PlatformRegionKey();
        platformRegionKey.setPlatformId(primaryKey);
        return this.platformRegionMapper.deleteByPrimaryKey(platformRegionKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(PlatformRegionExample platformRegionExample) 
    {
        PlatformRegion platformRegion = new PlatformRegion();
        platformRegion.setIsDel("Y");
        return this.platformRegionMapper.updateByExampleSelective(platformRegion,platformRegionExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        PlatformRegion platformRegion = new PlatformRegion();
        platformRegion.setPlatformId(primaryKey);
        platformRegion.setIsDel("Y");
        return this.platformRegionMapper.updateByPrimaryKeySelective(platformRegion) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(PlatformRegion platformRegion) 
    {
        return this.platformRegionMapper.insertSelective(platformRegion) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(PlatformRegion platformRegion,PlatformRegionExample platformRegionExample) 
    {
        return this.platformRegionMapper.updateByExampleSelective(platformRegion,platformRegionExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(PlatformRegion platformRegion) 
    {
        return this.platformRegionMapper.updateByPrimaryKeySelective(platformRegion) > 0 ? true : false;
    }

}
