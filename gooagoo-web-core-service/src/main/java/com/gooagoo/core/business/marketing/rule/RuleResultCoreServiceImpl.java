package com.gooagoo.core.business.marketing.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.rule.RuleInfoCoreService;
import com.gooagoo.api.business.core.marketing.rule.RuleResultCoreService;
import com.gooagoo.api.generator.core.marketing.RuleInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.RuleResultGeneratorCoreService;
import com.gooagoo.api.protecteds.core.marketing.MarketingProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.marketing.RuleResultExample;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class RuleResultCoreServiceImpl implements RuleResultCoreService
{
    @Autowired
    private RuleInfoGeneratorCoreService ruleInfoGeneratorCoreService;
    @Autowired
    private RuleInfoCoreService ruleInfoCoreService;
    @Autowired
    private RuleResultGeneratorCoreService ruleResultGeneratorCoreService;
    @Autowired
    private MarketingProtectedCoreService marketingProtectedCoreService;

    @Override
    public boolean deleteRuleResult(String ruleResultId) throws Exception
    {
        if (!StringUtils.hasText(ruleResultId))
        {
            GooagooLog.warn("删除规则结果：id为空");
            return false;
        }
        return this.ruleResultGeneratorCoreService.deleteByPrimaryKey(ruleResultId);
    }

    @Override
    public boolean addRuleResult(RuleResult ruleResult) throws Exception
    {
        ruleResult.setIsDel("N");
        ruleResult.setPublishStatus("W");
        return this.ruleResultGeneratorCoreService.insertSelective(ruleResult);
    }

    @Override
    public boolean updateRuleResult(RuleResult ruleResult) throws Exception
    {
        ruleResult.setPublishStatus("W");
        return this.ruleResultGeneratorCoreService.updateByPrimaryKeySelective(ruleResult);
    }

    @Override
    public boolean reviewedRuleResult(String ruleResultId, String status, String note) throws Exception
    {
        RuleResult ruleResult = this.ruleResultGeneratorCoreService.selectByPrimaryKey(ruleResultId);
        if (ruleResult == null)
        {
            GooagooLog.warn("ruleResultId=" + ruleResultId + "规则结果不存在");
            return false;
        }
        if (!"W".equals(ruleResult.getPublishStatus()))
        {
            GooagooLog.warn("审核规则结果：规则结果状态不是待审核，ruleInfoId=" + ruleResultId + ",publishStatus=" + ruleResult.getPublishStatus());
            return false;
        }
        RuleResult reviewed = new RuleResult();
        reviewed.setRuleResultId(ruleResultId);
        reviewed.setAuditNote(note);
        if ("Y".equals(status))
        {
            reviewed.setPublishStatus("A");
        }
        else
        {
            reviewed.setPublishStatus("B");
        }
        return this.ruleResultGeneratorCoreService.updateByPrimaryKeySelective(reviewed);
    }

    @Override
    public boolean publishRuleResult(RuleResult ruleResult) throws Exception
    {
        if ("P".equals(ruleResult.getPublishStatus()))
        {
            GooagooLog.warn("发布规则结果：规则结果已发布，obj=" + new Gson().toJson(ruleResult));
            return false;
        }
        if (!"A".equals(ruleResult.getPublishStatus()))
        {
            GooagooLog.warn("发布规则结果：规则结果未审核通过，obj=" + new Gson().toJson(ruleResult));
            return false;
        }
        RuleResult ruleResultNew = new RuleResult();
        ruleResultNew.setRuleResultId(ruleResult.getRuleResultId());
        ruleResultNew.setPublishStatus("P");
        return this.ruleResultGeneratorCoreService.updateByPrimaryKeySelective(ruleResultNew);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteRuleResultAndInfo(String ruleInfoId) throws Exception
    {
        RuleInfo ruleInfo = this.ruleInfoGeneratorCoreService.selectByPrimaryKey(ruleInfoId);
        boolean res = this.ruleInfoCoreService.deleteRuleInfo(ruleInfo.getRuleId());
        if (!res)
        {
            GooagooLog.warn("删除规则内容和信息：删除规则失败，RuleInfo.ruleId=" + ruleInfoId);
            return false;
        }
        RuleResultExample ruleResultExample = new RuleResultExample();
        ruleResultExample.createCriteria().andIsDelEqualTo("N").andRuleIdEqualTo(ruleInfo.getRuleId()).andRuleResultIdEqualTo(ruleInfo.getObjectId());
        res = this.ruleResultGeneratorCoreService.deleteByExample(ruleResultExample);
        if (!res)
        {
            GooagooLog.warn("删除规则内容和信息，删除规则结果失败：obj=" + new Gson().toJson(ruleResultExample));
            throw new OperateFailException("删除规则失败");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addRuleResultAndInfo(RuleResult ruleResult, RuleInfo ruleInfo) throws Exception
    {
        if (!ruleResult.getRuleId().equals(ruleInfo.getRuleId()))
        {
            GooagooLog.warn("添加规则内容和信息，规则信息和规则结果表中的规则Id不一致：ruleInfo.getRuleId=" + ruleInfo.getRuleId() + ",ruleResult.getRuleId=" + ruleResult.getRuleId());
            return false;
        }
        if (!ruleResult.getRuleResultId().equals(ruleInfo.getObjectId()))
        {
            GooagooLog.warn("添加规则内容和信息，规则信息和规则结果表中的规则结果Id不一致：ruleInfo.getObjectId=" + ruleInfo.getObjectId() + ",ruleResult.getRuleResultId=" + ruleResult.getRuleResultId());
            return false;
        }
        boolean res = this.ruleInfoCoreService.addRuleInfo(ruleInfo);
        if (!res)
        {
            GooagooLog.warn("添加规则内容和信息，添加规则信息失败：ruleInfo=" + new Gson().toJson(ruleInfo));
            return false;
        }
        res = this.addRuleResult(ruleResult);
        if (!res)
        {
            GooagooLog.warn("添加规则内容和信息，添加规则结果失败：ruleResult=" + new Gson().toJson(ruleResult));
            throw new OperateFailException("添加规则失败");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateRuleResultAndInfo(RuleResult ruleResult, RuleInfo ruleInfo) throws Exception
    {
        if (!ruleResult.getRuleId().equals(ruleInfo.getRuleId()))
        {
            GooagooLog.warn("修改规则内容和信息，规则信息和规则结果表中的规则Id不一致：ruleInfo.getRuleId=" + ruleInfo.getRuleId() + ",ruleResult.getRuleId=" + ruleResult.getRuleId());
            return false;
        }
        if (!ruleResult.getRuleResultId().equals(ruleInfo.getObjectId()))
        {
            GooagooLog.warn("修改规则内容和信息，规则信息和规则结果表中的规则结果Id不一致：ruleInfo.getObjectId=" + ruleInfo.getObjectId() + ",ruleResult.getRuleResultId=" + ruleResult.getRuleResultId());
            return false;
        }
        boolean res = this.ruleInfoCoreService.updateRuleInfo(ruleInfo);
        if (!res)
        {
            GooagooLog.warn("修改规则内容和信息，修改规则信息失败：ruleInfo=" + new Gson().toJson(ruleInfo));
            return false;
        }
        res = this.updateRuleResult(ruleResult);
        if (!res)
        {
            GooagooLog.warn("修改规则内容和信息，修改规则结果失败：ruleResult=" + new Gson().toJson(ruleResult));
            throw new OperateFailException("修改规则失败");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean reviewedRuleResultAndInfo(String ruleInfoId, String status, String note) throws Exception
    {
        RuleInfo ruleInfo = this.ruleInfoGeneratorCoreService.selectByPrimaryKey(ruleInfoId);
        boolean res = this.ruleInfoCoreService.reviewedRuleInfo(ruleInfo.getRuleId(), status, note);
        if (!res)
        {
            GooagooLog.warn("审核规则内容和信息，审核规则信息失败：ruleId=" + ruleInfo.getRuleId() + ",status=" + status + ",status=" + note);
            return false;
        }
        res = this.reviewedRuleResult(ruleInfo.getObjectId(), status, note);
        if (!res)
        {
            GooagooLog.warn("审核规则内容和信息，审核规则结果失败：ruleResultId=" + ruleInfo.getObjectId() + ",status=" + status + ",status=" + note);
            throw new OperateFailException("审核规则失败");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean publishRuleResultAndInfo(String ruleInfoId, List<Account> userList) throws Exception
    {
        RuleInfo ruleInfo = this.ruleInfoGeneratorCoreService.selectByPrimaryKey(ruleInfoId);
        RuleResult ruleResult = this.ruleResultGeneratorCoreService.selectByPrimaryKey(ruleInfo.getObjectId());
        boolean res = this.ruleInfoCoreService.publishRuleInfo(ruleInfo);
        if (!res)
        {
            GooagooLog.warn("发布规则内容和信息，修改规则信息发布状态失败：ruleInfo=" + new Gson().toJson(ruleInfo));
            return false;
        }
        res = this.publishRuleResult(ruleResult);
        if (!res)
        {
            GooagooLog.warn("发布规则内容和信息，修改规则结果发布状态失败：ruleResult=" + new Gson().toJson(ruleResult));
            throw new OperateFailException("发布规则失败");
        }
        this.marketingProtectedCoreService.saveMarketingUserLinkList(userList, ruleInfo);
        return true;
    }

}
