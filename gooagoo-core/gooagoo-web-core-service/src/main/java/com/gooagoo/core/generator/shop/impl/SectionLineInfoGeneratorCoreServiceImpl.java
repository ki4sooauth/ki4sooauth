package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.SectionLineInfoGeneratorCoreService;
import com.gooagoo.entity.generator.shop.SectionLineInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfoExample;
import com.gooagoo.entity.generator.shop.SectionLineInfoKey;
import com.gooagoo.dao.generator.shop.SectionLineInfoMapper;

@Service
public class SectionLineInfoGeneratorCoreServiceImpl implements SectionLineInfoGeneratorCoreService
{

    @Autowired
    private SectionLineInfoMapper sectionLineInfoMapper;

    @Override
    public Integer countByExample(SectionLineInfoExample sectionLineInfoExample) 
    {
        return this.sectionLineInfoMapper.countByExample(sectionLineInfoExample);
    }

    @Override
    public List<SectionLineInfo> selectByExample(SectionLineInfoExample sectionLineInfoExample) 
    {
        return this.sectionLineInfoMapper.selectByExample(sectionLineInfoExample);
    }

    @Override
    public SectionLineInfo selectByPrimaryKey(String primaryKey) 
    {
        SectionLineInfoKey sectionLineInfoKey = new SectionLineInfoKey();
        sectionLineInfoKey.setLineId(primaryKey);
        return this.sectionLineInfoMapper.selectByPrimaryKey(sectionLineInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(SectionLineInfoExample sectionLineInfoExample) 
    {
        return this.sectionLineInfoMapper.deleteByExample(sectionLineInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        SectionLineInfoKey sectionLineInfoKey = new SectionLineInfoKey();
        sectionLineInfoKey.setLineId(primaryKey);
        return this.sectionLineInfoMapper.deleteByPrimaryKey(sectionLineInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SectionLineInfo sectionLineInfo) 
    {
        return this.sectionLineInfoMapper.insertSelective(sectionLineInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SectionLineInfo sectionLineInfo,SectionLineInfoExample sectionLineInfoExample) 
    {
        return this.sectionLineInfoMapper.updateByExampleSelective(sectionLineInfo,sectionLineInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SectionLineInfo sectionLineInfo) 
    {
        return this.sectionLineInfoMapper.updateByPrimaryKeySelective(sectionLineInfo) > 0 ? true : false;
    }

}
