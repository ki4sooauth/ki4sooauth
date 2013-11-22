package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.EmailConfig;
import com.gooagoo.entity.generator.base.EmailConfigExample;
import com.gooagoo.entity.generator.base.EmailConfigKey;

public interface EmailConfigMapper
{

    public Integer countByExample(EmailConfigExample emailConfigExample);

    public List<EmailConfig> selectByExample(EmailConfigExample emailConfigExample);

    public EmailConfig selectByPrimaryKey(EmailConfigKey emailConfigKey);

    public Integer deleteByExample(EmailConfigExample emailConfigExample);

    public Integer deleteByPrimaryKey(EmailConfigKey emailConfigKey);

    public Integer insertSelective(EmailConfig emailConfig);

    public Integer updateAllByExample(@Param("record") EmailConfig emailConfig, @Param("example") EmailConfigExample emailConfigExample);

    public Integer updateByExampleSelective(@Param("record") EmailConfig emailConfig, @Param("example") EmailConfigExample emailConfigExample);

    public Integer updateByPrimaryKeySelective(EmailConfig emailConfig);

}
