package com.gooagoo.igms.message.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.shortmessage.ShortMessageCoreService;
import com.gooagoo.api.generator.query.marketing.ShortMessageGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.ShortMessage;
import com.gooagoo.entity.generator.marketing.ShortMessageExample;
import com.gooagoo.entity.generator.marketing.ShortMessageExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.common.utils.ReleaseUtil;
import com.gooagoo.igms.message.service.IShortMessage;
import com.gooagoo.igms.userAccount.service.UserAccountService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.message.FShortMessage;
import com.gooagoo.view.gms.rule.FRuleInfo;

@Service(value = "messageService")
public class ShortMessageImpl implements IShortMessage
{

    @Autowired
    private ShortMessageGeneratorQueryService shortMessageGeneratorQueryService;
    @Autowired
    private ShortMessageCoreService shortMessageCoreService;
    @Autowired
    private UserAccountService userAccountService;

    /**
     * 添加短信
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FShortMessage message = ServletUtils.objectMethod(FShortMessage.class, request);
        String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId", "");

        message.setMessageId(marketingId);
        message.setShopId(shopId);
        ShortMessage shortMessage = this.covertToShortMessage(message);

        boolean result = this.checkShortMessage(shortMessage);
        if (result)
        {
            result = this.shortMessageCoreService.addShortMessage(shortMessage);
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) shortMessage.getMessageId(), shortMessage.getMessageId());
    }

    /**
     * 删除短信
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String messageId = ServletRequestUtils.getStringParameter(request, "id", "");

        boolean result = this.shortMessageCoreService.deleteShortMessage(messageId);

        return new TransData<Object>(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, messageId);
    }

    /**
     * 修改短信
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FShortMessage message = ServletUtils.objectMethod(FShortMessage.class, request);
        message.setShopId(shopId);

        ShortMessage shortMessage = this.covertToShortMessage(message);

        boolean result = this.checkShortMessage(shortMessage);
        if (result)
        {
            result = this.shortMessageCoreService.updateShortMessage(shortMessage);
        }

        return new TransData<Object>(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, message.getMessageId());
    }

    /**
     * 短信列表
     */
    @Override
    public TransData<PageModel<FShortMessage>> messageList(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FShortMessage message = ServletUtils.objectMethod(FShortMessage.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);

        PageModel<FShortMessage> pm = new PageModel<FShortMessage>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        ShortMessageExample example = new ShortMessageExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(message.getActivityId()))
        {
            criteria.andActivityIdEqualTo(message.getActivityId());
        }
        if (org.springframework.util.StringUtils.hasText(message.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(message.getPublishStatus());
        }

        Integer count = this.shortMessageGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<ShortMessage> list = this.shortMessageGeneratorQueryService.selectByExample(example);
            for (ShortMessage shortMessage : list)
            {
                pm.getResult().add(this.covertToFShortMessage(shortMessage));
            }
        }

        return new TransData<PageModel<FShortMessage>>(true, null, pm);
    }

    /**
     * 短信详细信息
     */
    @Override
    public TransData<FShortMessage> getMessage(HttpServletRequest request) throws Exception
    {
        String messageId = ServletRequestUtils.getStringParameter(request, "id", "");

        ShortMessage shortMessage = this.shortMessageGeneratorQueryService.selectUnDelByPrimaryKey(messageId);
        FShortMessage message = this.covertToFShortMessage(shortMessage);

        return new TransData<FShortMessage>(true, null, message, messageId);
    }

    /**
     * 审核短信
     */
    @Override
    public TransData<Object> check(HttpServletRequest request) throws Exception
    {
        String messageId = ServletRequestUtils.getStringParameter(request, "id", "");
        String publishStatus = ServletRequestUtils.getStringParameter(request, "status", "N");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        boolean result = this.shortMessageCoreService.reviewedShortMessage(messageId, publishStatus, note);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, messageId);
    }

    /**
     * 发布短信
     */
    @Override
    public TransData<Object> release(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String messageId = ServletRequestUtils.getStringParameter(request, "id", "");

        FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);

        RuleInfo ruleInfo = this.covertToRuleInfo(fRuleInfo);

        List<Account> userList = null;
        if (!"1".equals(ruleInfo.getCrowdType()))
        {
            userList = this.userAccountService.getUserAccountList(fRuleInfo, shopId, "");
        }

        boolean result = this.shortMessageCoreService.publishShortMessage(messageId, userList, ruleInfo);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, messageId);
    }

    private FShortMessage covertToFShortMessage(ShortMessage shortMessage) throws IllegalArgumentException, IllegalAccessException
    {
        FShortMessage message = new FShortMessage();
        if (shortMessage != null)
        {
            EntityTools.copyValue(shortMessage, message);
        }
        return message;
    }

    private ShortMessage covertToShortMessage(FShortMessage message) throws IllegalArgumentException, IllegalAccessException
    {
        ShortMessage shortMessage = new ShortMessage();
        if (message != null)
        {
            EntityTools.copyValue(message, shortMessage);
        }
        return shortMessage;
    }

    private RuleInfo covertToRuleInfo(FRuleInfo fRuleInfo) throws IllegalArgumentException, IllegalAccessException
    {
        RuleInfo ruleInfo = new RuleInfo();
        if (fRuleInfo != null)
        {
            EntityTools.copyValue(fRuleInfo, ruleInfo);
        }
        return ruleInfo;
    }

    private boolean checkShortMessage(ShortMessage shortMessage)
    {
        if (shortMessage == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(shortMessage.getMessageId()) || shortMessage.getMessageId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(shortMessage.getMessageTitle()) || shortMessage.getMessageTitle().length() > 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(shortMessage.getContent()) || shortMessage.getContent().length() > 300)
        {
            return false;
        }

        return true;
    }
}
