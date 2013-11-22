package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.PlatformRegion;
import com.gooagoo.entity.generator.sys.PlatformRegionExample;
import com.gooagoo.entity.generator.sys.PlatformRegionKey;

public interface PlatformRegionMapper
{

    public Integer countByExample(PlatformRegionExample platformRegionExample);

    public List<PlatformRegion> selectByExample(PlatformRegionExample platformRegionExample);

    public PlatformRegion selectByPrimaryKey(PlatformRegionKey platformRegionKey);

    public Integer deleteByExample(PlatformRegionExample platformRegionExample);

    public Integer deleteByPrimaryKey(PlatformRegionKey platformRegionKey);

    public Integer insertSelective(PlatformRegion platformRegion);

    public Integer updateAllByExample(@Param("record") PlatformRegion platformRegion, @Param("example") PlatformRegionExample platformRegionExample);

    public Integer updateByExampleSelective(@Param("record") PlatformRegion platformRegion, @Param("example") PlatformRegionExample platformRegionExample);

    public Integer updateByPrimaryKeySelective(PlatformRegion platformRegion);

}
