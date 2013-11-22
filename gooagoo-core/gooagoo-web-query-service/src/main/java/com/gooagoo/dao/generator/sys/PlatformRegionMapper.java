package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.PlatformRegion;
import com.gooagoo.entity.generator.sys.PlatformRegionExample;
import com.gooagoo.entity.generator.sys.PlatformRegionKey;

public interface PlatformRegionMapper
{

    public Integer countByExample(PlatformRegionExample platformRegionExample);

    public List<PlatformRegion> selectByExample(PlatformRegionExample platformRegionExample);

    public PlatformRegion selectByPrimaryKey(PlatformRegionKey platformRegionKey);

}
