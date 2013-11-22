package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.ConvertApplyGeneratorQueryService;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.ConvertApplyExample;
import com.gooagoo.entity.generator.member.ConvertApplyKey;
import com.gooagoo.dao.generator.member.ConvertApplyMapper;

@Service
public class ConvertApplyGeneratorQueryServiceImpl implements ConvertApplyGeneratorQueryService
{

    @Autowired
    private ConvertApplyMapper convertApplyMapper;

    @Override
    public Integer countByExample(ConvertApplyExample convertApplyExample) 
    {
        return this.convertApplyMapper.countByExample(convertApplyExample);
    }

    @Override
    public List<ConvertApply> selectByExample(ConvertApplyExample convertApplyExample) 
    {
        return this.convertApplyMapper.selectByExample(convertApplyExample);
    }

    @Override
    public ConvertApply selectUnDelByPrimaryKey(String primaryKey) 
    {
        ConvertApplyKey convertApplyKey = new ConvertApplyKey();
        convertApplyKey.setIsDel("N");
        convertApplyKey.setApplicationId(primaryKey);
        return this.convertApplyMapper.selectByPrimaryKey(convertApplyKey);
    }

    @Override
    public ConvertApply selectByPrimaryKey(String primaryKey) 
    {
        ConvertApplyKey convertApplyKey = new ConvertApplyKey();
        convertApplyKey.setApplicationId(primaryKey);
        return this.convertApplyMapper.selectByPrimaryKey(convertApplyKey);
    }

}
