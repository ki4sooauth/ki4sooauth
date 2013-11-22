package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MRuleConfig;

public interface RuleConfigService
{
    /**
     * 新增规则配置
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addRuleConfig(HttpServletRequest request) throws Exception;

    /**
     * 修改规则配置
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateRuleConfig(HttpServletRequest request) throws Exception;

    /**
     * 删除规则配置
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> deleteRuleConfig(HttpServletRequest request) throws Exception;

    /**
     * 查询所有规则配置
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MRuleConfig>> queryAllRuleConfig(HttpServletRequest request) throws Exception;

    /**
     * 查询规则配置详细
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MRuleConfig> queryRuleConfig(HttpServletRequest request) throws Exception;

}
