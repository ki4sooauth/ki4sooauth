package com.gooagoo.dao.generator.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.generator.member.IntegralDetailInfoExample;
import com.gooagoo.entity.generator.member.IntegralDetailInfoKey;

public interface IntegralDetailInfoMapper
{

    public Integer countByExample(IntegralDetailInfoExample integralDetailInfoExample);

    public List<IntegralDetailInfo> selectByExample(IntegralDetailInfoExample integralDetailInfoExample);

    public IntegralDetailInfo selectByPrimaryKey(IntegralDetailInfoKey integralDetailInfoKey);

    public Integer deleteByExample(IntegralDetailInfoExample integralDetailInfoExample);

    public Integer deleteByPrimaryKey(IntegralDetailInfoKey integralDetailInfoKey);

    public Integer insertSelective(IntegralDetailInfo integralDetailInfo);

    public Integer updateAllByExample(@Param("record") IntegralDetailInfo integralDetailInfo, @Param("example") IntegralDetailInfoExample integralDetailInfoExample);

    public Integer updateByExampleSelective(@Param("record") IntegralDetailInfo integralDetailInfo, @Param("example") IntegralDetailInfoExample integralDetailInfoExample);

    public Integer updateByPrimaryKeySelective(IntegralDetailInfo integralDetailInfo);

}
