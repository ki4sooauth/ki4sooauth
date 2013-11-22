package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.MobileVersion;
import com.gooagoo.entity.generator.sys.MobileVersionExample;
import com.gooagoo.entity.generator.sys.MobileVersionKey;

public interface MobileVersionMapper
{

    public Integer countByExample(MobileVersionExample mobileVersionExample);

    public List<MobileVersion> selectByExample(MobileVersionExample mobileVersionExample);

    public MobileVersion selectByPrimaryKey(MobileVersionKey mobileVersionKey);

}
