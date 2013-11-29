package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.SysSecurityQuestionGeneratorCoreService;
import com.gooagoo.entity.generator.user.SysSecurityQuestion;
import com.gooagoo.entity.generator.user.SysSecurityQuestionExample;
import com.gooagoo.entity.generator.user.SysSecurityQuestionKey;
import com.gooagoo.dao.generator.user.SysSecurityQuestionMapper;

@Service
public class SysSecurityQuestionGeneratorCoreServiceImpl implements SysSecurityQuestionGeneratorCoreService
{

    @Autowired
    private SysSecurityQuestionMapper sysSecurityQuestionMapper;

    @Override
    public Integer countByExample(SysSecurityQuestionExample sysSecurityQuestionExample) 
    {
        return this.sysSecurityQuestionMapper.countByExample(sysSecurityQuestionExample);
    }

    @Override
    public List<SysSecurityQuestion> selectByExample(SysSecurityQuestionExample sysSecurityQuestionExample) 
    {
        return this.sysSecurityQuestionMapper.selectByExample(sysSecurityQuestionExample);
    }

    @Override
    public SysSecurityQuestion selectUnDelByPrimaryKey(String primaryKey) 
    {
        SysSecurityQuestionKey sysSecurityQuestionKey = new SysSecurityQuestionKey();
        sysSecurityQuestionKey.setIsDel("N");
        sysSecurityQuestionKey.setSysId(primaryKey);
        return this.sysSecurityQuestionMapper.selectByPrimaryKey(sysSecurityQuestionKey);
    }

    @Override
    public SysSecurityQuestion selectByPrimaryKey(String primaryKey) 
    {
        SysSecurityQuestionKey sysSecurityQuestionKey = new SysSecurityQuestionKey();
        sysSecurityQuestionKey.setSysId(primaryKey);
        return this.sysSecurityQuestionMapper.selectByPrimaryKey(sysSecurityQuestionKey);
    }

    @Override
    public boolean physicalDeleteByExample(SysSecurityQuestionExample sysSecurityQuestionExample) 
    {
        return this.sysSecurityQuestionMapper.deleteByExample(sysSecurityQuestionExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        SysSecurityQuestionKey sysSecurityQuestionKey = new SysSecurityQuestionKey();
        sysSecurityQuestionKey.setSysId(primaryKey);
        return this.sysSecurityQuestionMapper.deleteByPrimaryKey(sysSecurityQuestionKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(SysSecurityQuestionExample sysSecurityQuestionExample) 
    {
        SysSecurityQuestion sysSecurityQuestion = new SysSecurityQuestion();
        sysSecurityQuestion.setIsDel("Y");
        return this.sysSecurityQuestionMapper.updateByExampleSelective(sysSecurityQuestion,sysSecurityQuestionExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        SysSecurityQuestion sysSecurityQuestion = new SysSecurityQuestion();
        sysSecurityQuestion.setSysId(primaryKey);
        sysSecurityQuestion.setIsDel("Y");
        return this.sysSecurityQuestionMapper.updateByPrimaryKeySelective(sysSecurityQuestion) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SysSecurityQuestion sysSecurityQuestion) 
    {
        return this.sysSecurityQuestionMapper.insertSelective(sysSecurityQuestion) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SysSecurityQuestion sysSecurityQuestion,SysSecurityQuestionExample sysSecurityQuestionExample) 
    {
        return this.sysSecurityQuestionMapper.updateByExampleSelective(sysSecurityQuestion,sysSecurityQuestionExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SysSecurityQuestion sysSecurityQuestion) 
    {
        return this.sysSecurityQuestionMapper.updateByPrimaryKeySelective(sysSecurityQuestion) > 0 ? true : false;
    }

}
