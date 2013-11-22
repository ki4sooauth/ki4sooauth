package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.AdsManageGeneratorQueryService;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.entity.generator.sys.AdsManageKey;
import com.gooagoo.dao.generator.sys.AdsManageMapper;

@Service
public class AdsManageGeneratorQueryServiceImpl implements AdsManageGeneratorQueryService
{

    @Autowired
    private AdsManageMapper adsManageMapper;

    @Override
    public Integer countByExample(AdsManageExample adsManageExample) 
    {
        return this.adsManageMapper.countByExample(adsManageExample);
    }

    @Override
    public List<AdsManage> selectByExample(AdsManageExample adsManageExample) 
    {
        return this.adsManageMapper.selectByExample(adsManageExample);
    }

    @Override
    public AdsManage selectUnDelByPrimaryKey(String primaryKey) 
    {
        AdsManageKey adsManageKey = new AdsManageKey();
        adsManageKey.setIsDel("N");
        adsManageKey.setBidId(primaryKey);
        return this.adsManageMapper.selectByPrimaryKey(adsManageKey);
    }

    @Override
    public AdsManage selectByPrimaryKey(String primaryKey) 
    {
        AdsManageKey adsManageKey = new AdsManageKey();
        adsManageKey.setBidId(primaryKey);
        return this.adsManageMapper.selectByPrimaryKey(adsManageKey);
    }

}
