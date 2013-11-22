package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.entity.generator.sys.AdsManageKey;

public interface AdsManageMapper
{

    public Integer countByExample(AdsManageExample adsManageExample);

    public List<AdsManage> selectByExample(AdsManageExample adsManageExample);

    public AdsManage selectByPrimaryKey(AdsManageKey adsManageKey);

}
