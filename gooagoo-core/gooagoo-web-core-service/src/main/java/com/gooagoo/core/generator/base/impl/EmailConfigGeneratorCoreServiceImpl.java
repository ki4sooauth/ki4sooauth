package com.gooagoo.core.generator.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.base.EmailConfigGeneratorCoreService;
import com.gooagoo.entity.generator.base.EmailConfig;
import com.gooagoo.entity.generator.base.EmailConfigExample;
import com.gooagoo.entity.generator.base.EmailConfigKey;
import com.gooagoo.dao.generator.base.EmailConfigMapper;

@Service
public class EmailConfigGeneratorCoreServiceImpl implements EmailConfigGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(EmailConfigExample emailConfigExample) 
    {
        return this.emailConfigMapper.deleteByExample(emailConfigExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        EmailConfigKey emailConfigKey = new EmailConfigKey();
        emailConfigKey.setEmailId(primaryKey);
        return this.emailConfigMapper.deleteByPrimaryKey(emailConfigKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(EmailConfigExample emailConfigExample) 
    {
        EmailConfig emailConfig = new EmailConfig();
        emailConfig.setIsDel("Y");
        return this.emailConfigMapper.updateByExampleSelective(emailConfig,emailConfigExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        EmailConfig emailConfig = new EmailConfig();
        emailConfig.setEmailId(primaryKey);
        emailConfig.setIsDel("Y");
        return this.emailConfigMapper.updateByPrimaryKeySelective(emailConfig) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(EmailConfig emailConfig) 
    {
        return this.emailConfigMapper.insertSelective(emailConfig) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(EmailConfig emailConfig,EmailConfigExample emailConfigExample) 
    {
        return this.emailConfigMapper.updateByExampleSelective(emailConfig,emailConfigExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(EmailConfig emailConfig) 
    {
        return this.emailConfigMapper.updateByPrimaryKeySelective(emailConfig) > 0 ? true : false;
    }

}
