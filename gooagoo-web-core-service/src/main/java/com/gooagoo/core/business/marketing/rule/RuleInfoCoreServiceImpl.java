package com.gooagoo.core.business.marketing.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.rule.RuleInfoCoreService;
import com.gooagoo.api.generator.core.marketing.RuleInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.google.gson.Gson;

@Service
public class RuleInfoCoreServiceImpl implements RuleInfoCoreService
{
    @Autowired
    private RuleInfoGeneratorCoreService ruleInfoGeneratorCoreService;

    @Override
    public boolean deleteRuleInfo(String ruleId) throws Exception
    {
        if (!StringUtils.hasText(ruleId))
        {
            GooagooLog.warn("删除规则信息：主键为空");
            return false;
        }
        return this.ruleInfoGeneratorCoreService.deleteByPrimaryKey(ruleId);
    }

    @Override
    public boolean addRuleInfo(RuleInfo ruleInfo) throws Exception
    {
        ruleInfo.setPublishStatus("W");
        ruleInfo.setIsActiveForever("N");
        ruleInfo.setIsDel("N");
        return this.ruleInfoGeneratorCoreService.insertSelective(ruleInfo);
    }

    @Override
    public boolean updateRuleInfo(RuleInfo ruleInfo) throws Exception
    {
        ruleInfo.setPublishStatus("W");
        return this.ruleInfoGeneratorCoreService.updateByPrimaryKeySelective(ruleInfo);
    }

    @Override
    public boolean reviewedRuleInfo(String ruleInfoId, String status, String note) throws Exception
    {
        RuleInfo ruleInfo = this.ruleInfoGeneratorCoreService.selectByPrimaryKey(ruleInfoId);
        if (!"W".equals(ruleInfo.getPublishStatus()))
        {
            GooagooLog.warn("审核规则：规则状态不是待审核，ruleInfoId=" + ruleInfoId + ",publishStatus=" + ruleInfo.getPublishStatus());
            return false;
        }
        RuleInfo reviewed = new RuleInfo();
        reviewed.setRuleId(ruleInfoId);
        reviewed.setAuditNote(note);
        if ("Y".equals(status))
        {
            reviewed.setPublishStatus("A");
        }
        else
        {
            reviewed.setPublishStatus("B");
        }
        return this.ruleInfoGeneratorCoreService.updateByPrimaryKeySelective(reviewed);
    }

    @Override
    public boolean publishRuleInfo(RuleInfo ruleInfo) throws Exception
    {
        if ("P".equals(ruleInfo.getPublishStatus()))
        {
            GooagooLog.warn("发布规则：规则已发布，obj=" + new Gson().toJson(ruleInfo));
            return false;
        }
        if (!"A".equals(ruleInfo.getPublishStatus()))
        {
            GooagooLog.warn("发布规则：规则未审核通过，obj=" + new Gson().toJson(ruleInfo));
            return false;
        }
        RuleInfo reviewed = new RuleInfo();
        reviewed.setRuleId(ruleInfo.getRuleId());
        if ("Y".equals(ruleInfo.getIsPublishImmediately()))
        {
            reviewed.setPublishStatus("P");
        }
        else
        {
            reviewed.setPublishStatus("A");
        }
        return this.ruleInfoGeneratorCoreService.updateByPrimaryKeySelective(reviewed);
    }

}
