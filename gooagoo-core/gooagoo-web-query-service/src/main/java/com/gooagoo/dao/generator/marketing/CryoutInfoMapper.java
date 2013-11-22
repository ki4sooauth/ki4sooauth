package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.CryoutInfoKey;

public interface CryoutInfoMapper
{

    public Integer countByExample(CryoutInfoExample cryoutInfoExample);

    public List<CryoutInfo> selectByExample(CryoutInfoExample cryoutInfoExample);

    public CryoutInfo selectByPrimaryKey(CryoutInfoKey cryoutInfoKey);

}
