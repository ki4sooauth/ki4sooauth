package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.MobileVersion;
import com.gooagoo.entity.generator.sys.MobileVersionExample;
import com.gooagoo.entity.generator.sys.MobileVersionKey;

public interface MobileVersionMapper
{

    public Integer countByExample(MobileVersionExample mobileVersionExample);

    public List<MobileVersion> selectByExample(MobileVersionExample mobileVersionExample);

    public MobileVersion selectByPrimaryKey(MobileVersionKey mobileVersionKey);

    public Integer deleteByExample(MobileVersionExample mobileVersionExample);

    public Integer deleteByPrimaryKey(MobileVersionKey mobileVersionKey);

    public Integer insertSelective(MobileVersion mobileVersion);

    public Integer updateAllByExample(@Param("record") MobileVersion mobileVersion, @Param("example") MobileVersionExample mobileVersionExample);

    public Integer updateByExampleSelective(@Param("record") MobileVersion mobileVersion, @Param("example") MobileVersionExample mobileVersionExample);

    public Integer updateByPrimaryKeySelective(MobileVersion mobileVersion);

}
