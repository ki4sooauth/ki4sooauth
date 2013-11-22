package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.PlatformRegionGeneratorQueryService;
import com.gooagoo.entity.generator.sys.PlatformRegion;
import com.gooagoo.entity.generator.sys.PlatformRegionExample;
import com.gooagoo.entity.generator.sys.PlatformRegionKey;
import com.gooagoo.dao.generator.sys.PlatformRegionMapper;

@Service
public class PlatformRegionGeneratorQueryServiceImpl implements PlatformRegionGeneratorQueryService
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

}
