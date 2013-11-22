package com.gooagoo.core.business.marketing.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.marketing.user.MarketingUserLinkCoreService;
import com.gooagoo.api.generator.core.marketing.MarketingUserLinkGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;

@Service
public class MarketingUserLinkCoreServiceImpl implements MarketingUserLinkCoreService
{
    @Autowired
    private MarketingUserLinkGeneratorCoreService marketingUserLinkGeneratorCoreService;

    @Override
    public boolean insertSelective(MarketingUserLink marketingUserLink)
    {
        return this.marketingUserLinkGeneratorCoreService.insertSelective(marketingUserLink);
    }

    @Override
    public boolean updateByExampleSelective(MarketingUserLink marketingUserLink, MarketingUserLinkExample marketingUserLinkExample)
    {
        return this.marketingUserLinkGeneratorCoreService.updateByExampleSelective(marketingUserLink, marketingUserLinkExample);
    }

    @Override
    public boolean updateByPrimaryKeySelective(MarketingUserLink marketingUserLink)
    {
        return this.marketingUserLinkGeneratorCoreService.updateByPrimaryKeySelective(marketingUserLink);
    }
}
