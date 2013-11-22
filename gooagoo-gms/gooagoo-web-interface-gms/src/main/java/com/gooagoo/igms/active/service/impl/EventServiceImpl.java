package com.gooagoo.igms.active.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.event.EventCoreService;
import com.gooagoo.api.generator.query.marketing.MarketingEventGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingEventExample;
import com.gooagoo.entity.generator.marketing.MarketingEventExample.Criteria;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.business.sys.TemplateDataIsEmptyException;
import com.gooagoo.igms.active.service.EventService;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.common.utils.ReleaseUtil;
import com.gooagoo.igms.userAccount.service.UserAccountService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FEvent;
import com.gooagoo.view.gms.marketing.FMarketingItemLinkList;
import com.gooagoo.view.gms.rule.FRuleInfo;
import com.google.gson.Gson;

@Service(value = "eventService")
public class EventServiceImpl implements EventService
{
    @Autowired
    private MarketingEventGeneratorQueryService marketingEventGeneratorQueryService;
    @Autowired
    private EventCoreService eventCoreService;
    @Autowired
    private UserAccountService userAccountService;

    /**
     * 添加事件
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FEvent event = ServletUtils.objectMethod(FEvent.class, request);
        String channelRoot = ServletRequestUtils.getStringParameter(request, "channelCode", "");

        FMarketingItemLinkList itemLinkList = ServletUtils.objectMethod(FMarketingItemLinkList.class, request);
        String marketingId = ServletRequestUtils.getStringParameter(request, "marketingId", "");

        event.setEventId(marketingId);
        event.setShopId(shopId);
        event.setChannelRoot(channelRoot);
        event.setChannelLeaf(channelRoot);

        MarketingEvent marketingEvent = this.convertToMarketingEvent(event);
        List<String> linkIdList = itemLinkList.getMarketingLinkId();
        List<String> linkTypeList = itemLinkList.getMarketingLinkType();
        String[][] marketingItemLink = new String[linkIdList.size()][2];
        for (int i = 0; i < linkIdList.size(); i++)
        {
            marketingItemLink[i][0] = linkTypeList.get(i);
            marketingItemLink[i][1] = linkIdList.get(i);
        }
        if (marketingEvent.getTemplateId() == null)
        {
            marketingEvent.setTemplateId("");
        }
        if (marketingEvent.getTemplateData() == null)
        {
            marketingEvent.setTemplateData("");
        }
        boolean result = this.checkEventInfo(event, itemLinkList);
        if (result)
        {
            result = this.eventCoreService.addEvent(marketingEvent, marketingItemLink);
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) marketingEvent.getEventId(), marketingEvent.getEventId());
    }

    /**
     * 删除事件
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String eventId = ServletRequestUtils.getStringParameter(request, "id", "");

        boolean result = this.eventCoreService.deleteEvent(eventId);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, eventId);
    }

    /**
     * 修改事件
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FEvent event = ServletUtils.objectMethod(FEvent.class, request);
        FMarketingItemLinkList itemLinkList = ServletUtils.objectMethod(FMarketingItemLinkList.class, request);
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        String updateType = ServletRequestUtils.getStringParameter(request, "updateType", "");

        event.setShopId(shopId);
        event.setChannelRoot(channelCode);
        event.setChannelLeaf(channelCode);

        List<String> linkIdList = itemLinkList.getMarketingLinkId();
        List<String> linkTypeList = itemLinkList.getMarketingLinkType();
        String[][] marketingItemLink = new String[linkIdList.size()][2];
        for (int i = 0; i < linkIdList.size(); i++)
        {
            marketingItemLink[i][0] = linkTypeList.get(i);
            marketingItemLink[i][1] = linkIdList.get(i);
        }
        boolean result = false;
        if ("template".equals(updateType) && !org.apache.commons.lang.StringUtils.isBlank(event.getEventId()))
        {
            String edit = ServletRequestUtils.getStringParameter(request, "edit", "");
            String publish = ServletRequestUtils.getStringParameter(request, "publish", "");
            Map<String, String> map = new HashMap<String, String>();
            map.put("edit", edit);
            map.put("publish", publish);
            String templateData = new Gson().toJson(map);

            event.setTemplateData(templateData);
            result = true;
        }
        else
        {
            result = this.checkEventInfo(event, itemLinkList);
        }
        if (result)
        {
            MarketingEvent marketingEvent = this.convertToMarketingEvent(event);
            result = this.eventCoreService.updateEvent(marketingEvent, marketingItemLink);
        }

        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, (Object) event.getEventId(), event.getEventId());
    }

    /**
     * 事件列表
     */
    @Override
    public TransData<PageModel<FEvent>> pageEvent(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FEvent event = ServletUtils.objectMethod(FEvent.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");

        PageModel<FEvent> pm = new PageModel<FEvent>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        MarketingEventExample example = new MarketingEventExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo("N");
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(event.getActivityId()))
        {
            criteria.andActivityIdEqualTo(event.getActivityId());
        }
        if (org.springframework.util.StringUtils.hasText(channelCode))
        {
            criteria.andChannelRootEqualTo(channelCode);
        }
        if (org.springframework.util.StringUtils.hasText(event.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(event.getPublishStatus());
        }

        List<MarketingEvent> list = this.marketingEventGeneratorQueryService.selectByExample(example);
        for (MarketingEvent marketingEvent : list)
        {
            pm.getResult().add(this.convertToFEvent(marketingEvent));
        }

        return new TransData<PageModel<FEvent>>(true, null, pm);
    }

    /**
     * 事件详细信息（基本）
     */
    @Override
    public TransData<FEvent> getEvent(HttpServletRequest request) throws Exception
    {
        String eventId = ServletRequestUtils.getStringParameter(request, "id", "");

        MarketingEvent marketingEvent = this.marketingEventGeneratorQueryService.selectByPrimaryKey(eventId);
        FEvent event = this.convertToFEvent(marketingEvent);

        return new TransData<FEvent>(true, null, event);
    }

    /**
     * 审核事件
     */
    @Override
    public TransData<Object> check(HttpServletRequest request) throws Exception
    {
        String eventId = ServletRequestUtils.getStringParameter(request, "id", "");
        String publishStatus = ServletRequestUtils.getStringParameter(request, "status", "N");
        String note = ServletRequestUtils.getStringParameter(request, "content", "");

        boolean result = false;
        String failMessage = MessageConst.GMS_OPERATE_FAIL;
        try
        {
            result = this.eventCoreService.reviewedEvent(eventId, publishStatus, note);
        }
        catch (TemplateDataIsEmptyException e)
        {
            failMessage = MessageConst.GMS_TEMPLATEDATA_CAN_NOT_BE_EMPTY;
        }

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, failMessage, eventId);
    }

    /**
     * 发布事件
     */
    @Override
    public TransData<Object> release(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String eventId = ServletRequestUtils.getStringParameter(request, "id", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");

        FRuleInfo fRuleInfo = ReleaseUtil.getRuleInfo(request);

        RuleInfo ruleInfo = this.covertToRuleInfo(fRuleInfo);

        List<Account> userList = null;
        if (!"1".equals(ruleInfo.getCrowdType()))
        {
            userList = this.userAccountService.getUserAccountList(fRuleInfo, shopId, "");
        }

        boolean result = this.eventCoreService.publishEvent(eventId, channelCode, userList, ruleInfo);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, eventId);
    }

    /**
     * 查询事件详细信息
     */
    @Override
    public TransData<FEvent> form(HttpServletRequest request) throws Exception
    {
        String eventId = ServletRequestUtils.getStringParameter(request, "id", "");

        FEvent event = null;

        if (org.springframework.util.StringUtils.hasText(eventId))
        {
            MarketingEvent marketingEvent = this.marketingEventGeneratorQueryService.selectByPrimaryKey(eventId);
            event = this.convertToFEvent(marketingEvent);
        }

        return new TransData<FEvent>(true, null, event);
    }

    private FEvent convertToFEvent(MarketingEvent marketingEvent) throws IllegalArgumentException, IllegalAccessException
    {
        FEvent event = new FEvent();

        if (marketingEvent != null)
        {
            EntityTools.copyValue(marketingEvent, event);
        }

        return event;
    }

    private MarketingEvent convertToMarketingEvent(FEvent event) throws IllegalArgumentException, IllegalAccessException
    {
        MarketingEvent marketingEvent = new MarketingEvent();

        if (event != null)
        {
            EntityTools.copyValue(event, marketingEvent);
        }

        return marketingEvent;
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

    /**
     * 校验
     * @param event
     * @param itemLinkList
     * @return
     */
    private boolean checkEventInfo(FEvent event, FMarketingItemLinkList itemLinkList)
    {
        if (event == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(event.getEventId()) || event.getEventId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(event.getEventName()) || event.getEventName().length() > 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(event.getEventTarget()) || event.getEventTarget().length() > 255)
        {
            return false;
        }

        return true;
    }
}
