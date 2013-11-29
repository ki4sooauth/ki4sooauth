package com.gooagoo.core.business.marketing.event;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.marketing.event.EventCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingEventGeneratorCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingItemLinkGeneratorCoreService;
import com.gooagoo.api.protecteds.core.marketing.ActivityContentProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingItemLink;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkExample;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.business.sys.TemplateDataIsEmptyException;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class EventCoreServiceImpl implements EventCoreService
{
    @Autowired
    private MarketingEventGeneratorCoreService marketingEventGeneratorCoreService;
    @Autowired
    private MarketingItemLinkGeneratorCoreService marketingItemLinkGeneratorCoreService;
    @Autowired
    private ActivityContentProtectedCoreService activityContentProtectedCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addEvent(MarketingEvent marketingEvent, String[][] marketingItemLinks) throws Exception
    {
        //保存事件信息
        marketingEvent.setIsDel("N");
        marketingEvent.setPublishStatus("W");
        boolean res = this.marketingEventGeneratorCoreService.insertSelective(marketingEvent);
        if (!res)
        {
            GooagooLog.warn("修改事件失败，obj=" + new Gson().toJson(marketingEvent));
            return false;
        }
        //保存营销内容关联信息
        this.saveMarketingItemLinkList(marketingEvent, marketingItemLinks);

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean updateEvent(MarketingEvent marketingEvent, String[][] marketingItemLinks) throws Exception
    {
        //保存事件信息
        marketingEvent.setPublishStatus("W");
        boolean res = this.marketingEventGeneratorCoreService.updateByPrimaryKeySelective(marketingEvent);
        if (!res)
        {
            GooagooLog.warn("修改事件失败，obj=" + new Gson().toJson(marketingEvent));
            return false;
        }
        //保存营销内容关联信息
        MarketingEvent event = this.marketingEventGeneratorCoreService.selectByPrimaryKey(marketingEvent.getEventId());
        this.saveMarketingItemLinkList(event, marketingItemLinks);

        return true;
    }

    @Override
    public boolean reviewedEvent(String marketingEventId, String status, String note) throws Exception
    {
        MarketingEvent marketingEvent = this.marketingEventGeneratorCoreService.selectByPrimaryKey(marketingEventId);
        if (marketingEvent == null)
        {
            GooagooLog.warn("审核事件：事件不存在，marketingEventId=" + marketingEventId);
            return false;
        }
        if (!StringUtils.hasText(marketingEvent.getTemplateData()))
        {
            GooagooLog.info("事件模板数据不能为空[eventId=" + marketingEventId + "]");
            throw new TemplateDataIsEmptyException("事件模板数据不能为空[eventId=" + marketingEventId + "]");
        }
        if (!"W".equals(marketingEvent.getPublishStatus()))
        {
            GooagooLog.warn("审核事件：事件状态不是待审核，marketingEventId=" + marketingEventId + ",publishStatus=" + marketingEvent.getPublishStatus());
            return false;
        }
        MarketingEvent reviewed = new MarketingEvent();
        reviewed.setEventId(marketingEventId);
        reviewed.setAuditNote(note);
        if ("Y".equals(status))
        {
            reviewed.setPublishStatus("A");
        }
        else
        {
            reviewed.setPublishStatus("B");
        }
        return this.marketingEventGeneratorCoreService.updateByPrimaryKeySelective(reviewed);
    }

    @Override
    public boolean publishEvent(String eventId, String channelCode, List<Account> userList, RuleInfo ruleInfo) throws Exception
    {
        String ruleType = this.getRuleTypeByChannelCode(channelCode);
        return this.activityContentProtectedCoreService.release(eventId, ruleType, userList, ruleInfo);
    }

    @Override
    public boolean deleteEvent(String marketingEventId) throws Exception
    {
        if (!StringUtils.hasText(marketingEventId))
        {
            GooagooLog.warn("删除事件：事件Id为空");
            return false;
        }
        return this.marketingEventGeneratorCoreService.deleteByPrimaryKey(marketingEventId);
    }

    /**
     * 保存营销内容关联信息
     * @param marketingItemLink(0-营销内容关联类型,1-营销内容关联编号)
     * @param event
     * @return
     * @throws FetchviewException
     */
    private void saveMarketingItemLinkList(MarketingEvent marketingEvent, String[][] marketingItemLinks) throws Exception
    {
        if (marketingItemLinks != null && marketingItemLinks.length > 0)
        {

            String marketingType = this.getRuleTypeByChannelCode(marketingEvent.getChannelRoot());
            String marketingId = marketingEvent.getEventId();
            MarketingItemLinkExample marketingItemLinkExample = new MarketingItemLinkExample();
            marketingItemLinkExample.createCriteria().andIsDelEqualTo("N").andMarketingIdEqualTo(marketingId).andMarketingTypeEqualTo(marketingType);
            List<MarketingItemLink> links = this.marketingItemLinkGeneratorCoreService.selectByExample(marketingItemLinkExample);

            if (links != null && links.size() > 0)
            {
                MarketingItemLink link = links.get(0);
                link.setIsDel("Y");
                link.setCTimeStamp(null);
                boolean ret = this.marketingItemLinkGeneratorCoreService.updateByPrimaryKeySelective(link);

                if (!ret)
                {
                    GooagooLog.warn("营销内容关联信息：删除旧信息失败，link=" + new Gson().toJson(link));
                    throw new OperateFailException("删除旧营销内容关联信息失败");
                }
            }
            for (int i = 0; i < marketingItemLinks.length; i++)
            {
                if (marketingItemLinks[i].length != 2 || !StringUtils.hasText(marketingItemLinks[i][0]) || !StringUtils.hasText(marketingItemLinks[i][1]))
                {
                    GooagooLog.warn("营销内容关联信息：营销内容关联信息不全，marketingItemLinkList=" + new Gson().toJson(marketingItemLinks[i]));
                    throw new OperateFailException("营销内容关联信息不全");
                }
                String marketingLinkType = marketingItemLinks[i][0];
                String marketingLinkId = marketingItemLinks[i][1];

                MarketingItemLink marketingItemLink = new MarketingItemLink();
                marketingItemLink.setActivityId(marketingEvent.getActivityId());
                marketingItemLink.setCreateTime(new Date());
                marketingItemLink.setId(com.gooagoo.common.utils.StringUtils.getUUID());
                marketingItemLink.setIsDel("N");
                marketingItemLink.setMarketingId(marketingId);
                marketingItemLink.setMarketingType(marketingType);
                marketingItemLink.setMarketingLinkId(marketingLinkId);
                marketingItemLink.setMarketingLinkType(marketingLinkType);
                marketingItemLink.setShopId(marketingEvent.getShopId());
                marketingItemLink.setSort(i);
                boolean ret = this.marketingItemLinkGeneratorCoreService.insertSelective(marketingItemLink);
                if (!ret)
                {
                    GooagooLog.warn("保存营销内容关联信息失败：link=" + new Gson().toJson(marketingItemLink));
                    throw new OperateFailException("保存营销内容关联信息失败");
                }
            }
        }
    }

    /**
    * 通过渠道编码获取规则类型
    * @param channelCode
    * @return
    */
    private String getRuleTypeByChannelCode(String channelCode)
    {
        String ruleType = channelCode;
        if ("1".equals(channelCode))
        {
            ruleType = "1";
        }
        else if ("2".equals(channelCode))
        {
            ruleType = "2";
        }
        else if ("3".equals(channelCode))
        {
            ruleType = "4";
        }
        else if ("4".equals(channelCode))
        {
            ruleType = "3";
        }
        else if ("5".equals(channelCode))
        {
            ruleType = "0";
        }
        else if ("6".equals(channelCode))
        {
            ruleType = "D";
        }
        else if ("7".equals(channelCode))
        {
            ruleType = "E";
        }
        else if ("8".equals(channelCode))
        {
            ruleType = "F";
        }
        else if ("9".equals(channelCode))
        {
            ruleType = "G";
        }
        return ruleType;
    }
}
