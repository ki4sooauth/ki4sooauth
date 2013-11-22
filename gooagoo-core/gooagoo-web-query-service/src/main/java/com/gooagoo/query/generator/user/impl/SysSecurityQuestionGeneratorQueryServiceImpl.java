package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.SysSecurityQuestionGeneratorQueryService;
import com.gooagoo.entity.generator.user.SysSecurityQuestion;
import com.gooagoo.entity.generator.user.SysSecurityQuestionExample;
import com.gooagoo.entity.generator.user.SysSecurityQuestionKey;
import com.gooagoo.dao.generator.user.SysSecurityQuestionMapper;

@Service
public class SysSecurityQuestionGeneratorQueryServiceImpl implements SysSecurityQuestionGeneratorQueryService
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

}
