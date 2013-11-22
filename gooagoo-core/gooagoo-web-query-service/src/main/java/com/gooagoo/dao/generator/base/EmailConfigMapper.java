package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.EmailConfig;
import com.gooagoo.entity.generator.base.EmailConfigExample;
import com.gooagoo.entity.generator.base.EmailConfigKey;

public interface EmailConfigMapper
{

    public Integer countByExample(EmailConfigExample emailConfigExample);

    public List<EmailConfig> selectByExample(EmailConfigExample emailConfigExample);

    public EmailConfig selectByPrimaryKey(EmailConfigKey emailConfigKey);

}
