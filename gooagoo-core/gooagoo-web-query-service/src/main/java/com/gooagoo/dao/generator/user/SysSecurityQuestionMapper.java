package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.SysSecurityQuestion;
import com.gooagoo.entity.generator.user.SysSecurityQuestionExample;
import com.gooagoo.entity.generator.user.SysSecurityQuestionKey;

public interface SysSecurityQuestionMapper
{

    public Integer countByExample(SysSecurityQuestionExample sysSecurityQuestionExample);

    public List<SysSecurityQuestion> selectByExample(SysSecurityQuestionExample sysSecurityQuestionExample);

    public SysSecurityQuestion selectByPrimaryKey(SysSecurityQuestionKey sysSecurityQuestionKey);

}
