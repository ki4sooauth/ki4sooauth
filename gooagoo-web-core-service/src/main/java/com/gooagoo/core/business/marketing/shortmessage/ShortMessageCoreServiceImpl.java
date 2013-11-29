package com.gooagoo.core.business.marketing.shortmessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.shortmessage.ShortMessageCoreService;
import com.gooagoo.api.generator.core.marketing.ShortMessageGeneratorCoreService;
import com.gooagoo.api.protecteds.core.marketing.ActivityContentProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.ShortMessage;

@Service
public class ShortMessageCoreServiceImpl implements ShortMessageCoreService
{
    @Autowired
    private ShortMessageGeneratorCoreService shortMessageGeneratorCoreService;
    @Autowired
    private ActivityContentProtectedCoreService activityContentProtectedCoreService;

    @Override
    public boolean deleteShortMessage(String shortMessageId) throws Exception
    {
        if (!StringUtils.hasText(shortMessageId))
        {
            GooagooLog.warn("删除短信：短信Id为空");
            return false;
        }
        return this.shortMessageGeneratorCoreService.deleteByPrimaryKey(shortMessageId);
    }

    @Override
    public boolean addShortMessage(ShortMessage shortMessage) throws Exception
    {
        shortMessage.setIsDel("N");
        shortMessage.setPublishStatus("W");
        return this.shortMessageGeneratorCoreService.insertSelective(shortMessage);
    }

    @Override
    public boolean updateShortMessage(ShortMessage shortMessage) throws Exception
    {
        shortMessage.setPublishStatus("W");
        return this.shortMessageGeneratorCoreService.updateByPrimaryKeySelective(shortMessage);
    }

    @Override
    public boolean reviewedShortMessage(String shortMessageId, String status, String note) throws Exception
    {
        ShortMessage shortMessage = this.shortMessageGeneratorCoreService.selectByPrimaryKey(shortMessageId);
        if (shortMessage == null)
        {
            GooagooLog.warn("审核短信：短信不存在，shortMessageId=" + shortMessageId);
            return false;
        }
        if (!"W".equals(shortMessage.getPublishStatus()))
        {
            GooagooLog.warn("审核短信：短信状态不是待审核，shortMessageId=" + shortMessageId + ",publishStatus=" + shortMessage.getPublishStatus());
            return false;
        }
        ShortMessage reviewed = new ShortMessage();
        reviewed.setMessageId(shortMessageId);
        reviewed.setAuditNote(note);
        if ("Y".equals(status))
        {
            reviewed.setPublishStatus("A");
        }
        else
        {
            reviewed.setPublishStatus("B");
        }
        return this.shortMessageGeneratorCoreService.updateByPrimaryKeySelective(reviewed);
    }

    @Override
    public boolean publishShortMessage(String shortMessageId, List<Account> userList, RuleInfo ruleInfo) throws Exception
    {
        return this.activityContentProtectedCoreService.release(shortMessageId, "4", userList, ruleInfo);
    }
}
