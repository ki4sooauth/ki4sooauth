package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.generator.member.IntegralDetailInfoExample;
import com.gooagoo.entity.generator.member.IntegralDetailInfoKey;

public interface IntegralDetailInfoMapper
{

    public Integer countByExample(IntegralDetailInfoExample integralDetailInfoExample);

    public List<IntegralDetailInfo> selectByExample(IntegralDetailInfoExample integralDetailInfoExample);

    public IntegralDetailInfo selectByPrimaryKey(IntegralDetailInfoKey integralDetailInfoKey);

}
