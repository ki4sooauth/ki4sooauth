package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.IntegralInfoKey;

public interface IntegralInfoMapper
{

    public Integer countByExample(IntegralInfoExample integralInfoExample);

    public List<IntegralInfo> selectByExample(IntegralInfoExample integralInfoExample);

    public IntegralInfo selectByPrimaryKey(IntegralInfoKey integralInfoKey);

    public Integer deleteByExample(IntegralInfoExample integralInfoExample);

    public Integer deleteByPrimaryKey(IntegralInfoKey integralInfoKey);

    public Integer insertSelective(IntegralInfo integralInfo);

    public Integer updateAllByExample(@Param("record") IntegralInfo integralInfo, @Param("example") IntegralInfoExample integralInfoExample);

    public Integer updateByExampleSelective(@Param("record") IntegralInfo integralInfo, @Param("example") IntegralInfoExample integralInfoExample);

    public Integer updateByPrimaryKeySelective(IntegralInfo integralInfo);

}
