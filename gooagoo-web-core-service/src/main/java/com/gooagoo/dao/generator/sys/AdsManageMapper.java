package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.entity.generator.sys.AdsManageKey;

public interface AdsManageMapper
{

    public Integer countByExample(AdsManageExample adsManageExample);

    public List<AdsManage> selectByExample(AdsManageExample adsManageExample);

    public AdsManage selectByPrimaryKey(AdsManageKey adsManageKey);

    public Integer deleteByExample(AdsManageExample adsManageExample);

    public Integer deleteByPrimaryKey(AdsManageKey adsManageKey);

    public Integer insertSelective(AdsManage adsManage);

    public Integer updateAllByExample(@Param("record") AdsManage adsManage, @Param("example") AdsManageExample adsManageExample);

    public Integer updateByExampleSelective(@Param("record") AdsManage adsManage, @Param("example") AdsManageExample adsManageExample);

    public Integer updateByPrimaryKeySelective(AdsManage adsManage);

}
