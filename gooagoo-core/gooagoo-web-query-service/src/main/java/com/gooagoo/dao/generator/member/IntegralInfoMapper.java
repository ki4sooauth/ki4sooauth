package com.gooagoo.dao.generator.member;

import java.util.List;

import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.IntegralInfoKey;

public interface IntegralInfoMapper
{

    public Integer countByExample(IntegralInfoExample integralInfoExample);

    public List<IntegralInfo> selectByExample(IntegralInfoExample integralInfoExample);

    public IntegralInfo selectByPrimaryKey(IntegralInfoKey integralInfoKey);

}
