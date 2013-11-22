package com.gooagoo.query.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.EmailConfigGeneratorQueryService;
import com.gooagoo.entity.generator.base.EmailConfig;
import com.gooagoo.entity.generator.base.EmailConfigExample;
import com.gooagoo.entity.generator.base.EmailConfigKey;
import com.gooagoo.dao.generator.base.EmailConfigMapper;

@Service
public class EmailConfigGeneratorQueryServiceImpl implements EmailConfigGeneratorQueryService
{

    @Autowired
    private EmailConfigMapper emailConfigMapper;

    @Override
    public Integer countByExample(EmailConfigExample emailConfigExample) 
    {
        return this.emailConfigMapper.countByExample(emailConfigExample);
    }

    @Override
    public List<EmailConfig> selectByExample(EmailConfigExample emailConfigExample) 
    {
        return this.emailConfigMapper.selectByExample(emailConfigExample);
    }

    @Override
    public EmailConfig selectUnDelByPrimaryKey(String primaryKey) 
    {
        EmailConfigKey emailConfigKey = new EmailConfigKey();
        emailConfigKey.setIsDel("N");
        emailConfigKey.setEmailId(primaryKey);
        return this.emailConfigMapper.selectByPrimaryKey(emailConfigKey);
    }

    @Override
    public EmailConfig selectByPrimaryKey(String primaryKey) 
    {
        EmailConfigKey emailConfigKey = new EmailConfigKey();
        emailConfigKey.setEmailId(primaryKey);
        return this.emailConfigMapper.selectByPrimaryKey(emailConfigKey);
    }

}
