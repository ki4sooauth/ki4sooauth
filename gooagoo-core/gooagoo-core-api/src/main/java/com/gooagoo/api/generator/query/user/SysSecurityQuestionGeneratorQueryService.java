package com.gooagoo.api.generator.query.user;

import java.util.List;

import com.gooagoo.entity.generator.user.SysSecurityQuestion;
import com.gooagoo.entity.generator.user.SysSecurityQuestionExample;

public interface SysSecurityQuestionGeneratorQueryService
{

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_security_question用于查询表中对应数据条数
     * @param sysSecurityQuestionExample 查询条件
     * @return 数据条数
     */
    public Integer countByExample(SysSecurityQuestionExample sysSecurityQuestionExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_security_question用于查询数据，其中 create_time自动设置为当前数据库时间
     * @param sysSecurityQuestionExample 查询条件
     * @return 
     */
    public List<SysSecurityQuestion> selectByExample(SysSecurityQuestionExample sysSecurityQuestionExample) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_security_question用于查询数据
     * @param sysSecurityQuestionKey 查询条件，is_del默认为N,如果不想使用此条件请设置为null
     * @return 
     */
    public SysSecurityQuestion selectUnDelByPrimaryKey(String primaryKey) ;

    /**
     * This method was generated by PengYb
     * 此方法对应数据库表sys_security_question用于查询数据
     * @param primaryKey 查询条件，主键
     * @return 
     */
    public SysSecurityQuestion selectByPrimaryKey(String primaryKey) ;

}
