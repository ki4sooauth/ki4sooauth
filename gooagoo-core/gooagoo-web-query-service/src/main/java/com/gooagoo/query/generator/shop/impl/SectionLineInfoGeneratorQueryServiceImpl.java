package com.gooagoo.query.generator.shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.SectionLineInfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.SectionLineInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfoExample;
import com.gooagoo.entity.generator.shop.SectionLineInfoKey;
import com.gooagoo.dao.generator.shop.SectionLineInfoMapper;

@Service
public class SectionLineInfoGeneratorQueryServiceImpl implements SectionLineInfoGeneratorQueryService
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

}
