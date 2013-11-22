package com.gooagoo.igms.active.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.query.base.MarketingChannelGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingViewGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.MarketingChannelExample;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingView;
import com.gooagoo.entity.generator.marketing.MarketingViewExample;
import com.gooagoo.entity.generator.marketing.MarketingViewExample.Criteria;
import com.gooagoo.igms.active.service.ActivityContService;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FActivityContent;

@Service(value = "activityContService")
public class ActivityContServiceImpl implements ActivityContService
{
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;
    @Autowired
    private MarketingViewGeneratorQueryService marketingViewGeneratorQueryService;
    @Autowired
    private MarketingChannelGeneratorQueryService marketingChannelGeneratorQueryService;

    /**
     * 活动内容列表（根据活动ID查询，分页）
     */
    @Override
    public TransData<PageModel<FActivityContent>> pageContent(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FActivityContent content = ServletUtils.objectMethod(FActivityContent.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        pc.setOrderBy("c_time_stamp desc");
        PageModel<FActivityContent> pm = new PageModel<FActivityContent>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        MarketingViewExample example = new MarketingViewExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause(pc.getOrderBy());
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (StringUtils.hasText(content.getActivityId()))
        {
            criteria.andActivityIdEqualTo(content.getActivityId());
        }
        if (StringUtils.hasText(content.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(content.getPublishStatus());
        }
        if (StringUtils.hasText(content.getChannelCode()))
        {
            criteria.andChannelCodeEqualTo(content.getChannelCode());
        }
        if (StringUtils.hasText(content.getTitle()))
        {
            criteria.andTitleLike("%" + content.getTitle() + "%");
        }

        Integer count = this.marketingViewGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<MarketingView> resultList = this.marketingViewGeneratorQueryService.selectByExample(example);
            for (MarketingView marketingView : resultList)
            {
                pm.getResult().add(this.covertToFActivityContent(marketingView));
            }
        }

        return new TransData<PageModel<FActivityContent>>(true, null, pm);
    }

    /**
     * 活动内容列表（根据活动ID查询，不分页）
     */
    @Override
    public TransData<List<FActivityContent>> list(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FActivityContent content = ServletUtils.objectMethod(FActivityContent.class, request);

        MarketingViewExample example = new MarketingViewExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(content.getActivityId()))
        {
            criteria.andActivityIdEqualTo(content.getActivityId());
        }
        if (org.springframework.util.StringUtils.hasText(content.getPublishStatus()))
        {
            criteria.andActivityIdEqualTo(content.getPublishStatus());
        }

        List<MarketingView> resultList = this.marketingViewGeneratorQueryService.selectByExample(example);
        List<FActivityContent> list = new ArrayList<FActivityContent>();
        for (MarketingView marketingView : resultList)
        {
            list.add(this.covertToFActivityContent(marketingView));
        }
        return new TransData<List<FActivityContent>>(true, null, list);
    }

    /**
     * 渠道列表
     */
    @Override
    public TransData<List<FNode>> listChannel(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        MarketingChannelExample example = new MarketingChannelExample();
        com.gooagoo.entity.generator.base.MarketingChannelExample.Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andParentChannelCodeEqualTo("-1");

        List<FNode> list = new ArrayList<FNode>();
        if (StringUtils.hasText(shopId))
        {
            List<MarketingChannel> resultList = this.marketingChannelGeneratorQueryService.selectByExample(example);
            for (MarketingChannel marketingChannel : resultList)
            {
                list.add(this.covertToFNode(marketingChannel));
            }
        }

        return new TransData<List<FNode>>(true, null, list);
    }

    private FActivityContent covertToFActivityContent(MarketingView marketingView) throws Exception
    {
        FActivityContent fActivityContent = new FActivityContent();

        fActivityContent.setId(marketingView.getId());
        fActivityContent.setContentType(marketingView.getContentType());
        fActivityContent.setChannelCode(marketingView.getChannelCode());
        fActivityContent.setShopId(marketingView.getShopId());
        fActivityContent.setTitle(marketingView.getTitle());
        fActivityContent.setPublishStatus(marketingView.getPublishStatus());
        fActivityContent.setRuleId(marketingView.getRuleId());

        String activityId = marketingView.getActivityId();
        fActivityContent.setActivityId(activityId);

        MarketingActivity info = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(activityId);
        if (info != null)
        {
            if (StringUtils.hasText(info.getActivityName()) && info.getIsDel().equals("N"))
            {
                fActivityContent.setActivityName(info.getActivityName());
            }
        }
        if ("0".equals(marketingView.getContentType()) && fActivityContent.getPublishStatus().equals("P"))
        {
            fActivityContent.setContentUrl(UrlUtils.getEventUrl(marketingView.getId()));
        }
        return fActivityContent;
    }

    private FNode covertToFNode(MarketingChannel marketingChannel)
    {
        FNode node = null;
        if (marketingChannel != null)
        {
            node = new FNode();
            node.setCode(marketingChannel.getChannelCode().toString());
            node.setName(marketingChannel.getChannelName());
        }
        return node;
    }
}
