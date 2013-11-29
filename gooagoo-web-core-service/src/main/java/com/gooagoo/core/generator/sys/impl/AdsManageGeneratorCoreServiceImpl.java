package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.AdsManageGeneratorCoreService;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;
import com.gooagoo.entity.generator.sys.AdsManageKey;
import com.gooagoo.dao.generator.sys.AdsManageMapper;

@Service
public class AdsManageGeneratorCoreServiceImpl implements AdsManageGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(AdsManageExample adsManageExample) 
    {
        return this.adsManageMapper.deleteByExample(adsManageExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        AdsManageKey adsManageKey = new AdsManageKey();
        adsManageKey.setBidId(primaryKey);
        return this.adsManageMapper.deleteByPrimaryKey(adsManageKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(AdsManageExample adsManageExample) 
    {
        AdsManage adsManage = new AdsManage();
        adsManage.setIsDel("Y");
        return this.adsManageMapper.updateByExampleSelective(adsManage,adsManageExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        AdsManage adsManage = new AdsManage();
        adsManage.setBidId(primaryKey);
        adsManage.setIsDel("Y");
        return this.adsManageMapper.updateByPrimaryKeySelective(adsManage) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(AdsManage adsManage) 
    {
        return this.adsManageMapper.insertSelective(adsManage) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(AdsManage adsManage,AdsManageExample adsManageExample) 
    {
        return this.adsManageMapper.updateByExampleSelective(adsManage,adsManageExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(AdsManage adsManage) 
    {
        return this.adsManageMapper.updateByPrimaryKeySelective(adsManage) > 0 ? true : false;
    }

}
