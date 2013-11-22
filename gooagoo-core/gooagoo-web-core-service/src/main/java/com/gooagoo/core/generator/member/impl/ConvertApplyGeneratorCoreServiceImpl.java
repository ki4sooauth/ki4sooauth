package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.member.ConvertApplyGeneratorCoreService;
import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.entity.generator.member.ConvertApplyExample;
import com.gooagoo.entity.generator.member.ConvertApplyKey;
import com.gooagoo.dao.generator.member.ConvertApplyMapper;

@Service
public class ConvertApplyGeneratorCoreServiceImpl implements ConvertApplyGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(ConvertApplyExample convertApplyExample) 
    {
        return this.convertApplyMapper.deleteByExample(convertApplyExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        ConvertApplyKey convertApplyKey = new ConvertApplyKey();
        convertApplyKey.setApplicationId(primaryKey);
        return this.convertApplyMapper.deleteByPrimaryKey(convertApplyKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(ConvertApplyExample convertApplyExample) 
    {
        ConvertApply convertApply = new ConvertApply();
        convertApply.setIsDel("Y");
        return this.convertApplyMapper.updateByExampleSelective(convertApply,convertApplyExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        ConvertApply convertApply = new ConvertApply();
        convertApply.setApplicationId(primaryKey);
        convertApply.setIsDel("Y");
        return this.convertApplyMapper.updateByPrimaryKeySelective(convertApply) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(ConvertApply convertApply) 
    {
        return this.convertApplyMapper.insertSelective(convertApply) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ConvertApply convertApply,ConvertApplyExample convertApplyExample) 
    {
        return this.convertApplyMapper.updateByExampleSelective(convertApply,convertApplyExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ConvertApply convertApply) 
    {
        return this.convertApplyMapper.updateByPrimaryKeySelective(convertApply) > 0 ? true : false;
    }

}
