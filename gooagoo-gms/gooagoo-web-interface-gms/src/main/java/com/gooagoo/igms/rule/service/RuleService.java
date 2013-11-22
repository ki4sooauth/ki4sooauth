package com.gooagoo.igms.rule.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.rule.FRule;
import com.gooagoo.view.gms.rule.FRuleConfig;
import com.gooagoo.view.gms.rule.FRuleInfo;

public interface RuleService
{
    /**
     * 添加规则
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 删除规则信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 修改规则信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 获取规则列表信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FRuleInfo>> pageRule(HttpServletRequest request) throws Exception;

    /**
     * 获取规则详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FRule> getRuleInfo(HttpServletRequest request) throws Exception;

    /**
     * 审核发布规则信息 
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> approval(HttpServletRequest request) throws Exception;

    /**
     * 发布规则信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> publish(HttpServletRequest request) throws Exception;

    /**
     * 查询规则配置
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FRuleConfig> getConfig(HttpServletRequest request) throws Exception;

    /**
     * 查询商家下行为列表
     * @param request
     * @return
     * @throws Exception
     */
    TransData<Map<String, String>> getShopBehaveList(HttpServletRequest request) throws Exception;
}
