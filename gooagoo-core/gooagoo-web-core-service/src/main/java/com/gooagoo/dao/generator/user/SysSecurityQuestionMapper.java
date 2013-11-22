package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.SysSecurityQuestion;
import com.gooagoo.entity.generator.user.SysSecurityQuestionExample;
import com.gooagoo.entity.generator.user.SysSecurityQuestionKey;

public interface SysSecurityQuestionMapper
{

    public Integer countByExample(SysSecurityQuestionExample sysSecurityQuestionExample);

    public List<SysSecurityQuestion> selectByExample(SysSecurityQuestionExample sysSecurityQuestionExample);

    public SysSecurityQuestion selectByPrimaryKey(SysSecurityQuestionKey sysSecurityQuestionKey);

    public Integer deleteByExample(SysSecurityQuestionExample sysSecurityQuestionExample);

    public Integer deleteByPrimaryKey(SysSecurityQuestionKey sysSecurityQuestionKey);

    public Integer insertSelective(SysSecurityQuestion sysSecurityQuestion);

    public Integer updateAllByExample(@Param("record") SysSecurityQuestion sysSecurityQuestion, @Param("example") SysSecurityQuestionExample sysSecurityQuestionExample);

    public Integer updateByExampleSelective(@Param("record") SysSecurityQuestion sysSecurityQuestion, @Param("example") SysSecurityQuestionExample sysSecurityQuestionExample);

    public Integer updateByPrimaryKeySelective(SysSecurityQuestion sysSecurityQuestion);

}
