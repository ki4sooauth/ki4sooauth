package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.CryoutInfoKey;

public interface CryoutInfoMapper
{

    public Integer countByExample(CryoutInfoExample cryoutInfoExample);

    public List<CryoutInfo> selectByExample(CryoutInfoExample cryoutInfoExample);

    public CryoutInfo selectByPrimaryKey(CryoutInfoKey cryoutInfoKey);

    public Integer deleteByExample(CryoutInfoExample cryoutInfoExample);

    public Integer deleteByPrimaryKey(CryoutInfoKey cryoutInfoKey);

    public Integer insertSelective(CryoutInfo cryoutInfo);

    public Integer updateAllByExample(@Param("record") CryoutInfo cryoutInfo, @Param("example") CryoutInfoExample cryoutInfoExample);

    public Integer updateByExampleSelective(@Param("record") CryoutInfo cryoutInfo, @Param("example") CryoutInfoExample cryoutInfoExample);

    public Integer updateByPrimaryKeySelective(CryoutInfo cryoutInfo);

}
