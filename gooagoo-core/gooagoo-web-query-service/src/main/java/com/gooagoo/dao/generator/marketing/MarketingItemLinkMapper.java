package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.MarketingItemLink;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkKey;

public interface MarketingItemLinkMapper
{

    public Integer countByExample(MarketingItemLinkExample marketingItemLinkExample);

    public List<MarketingItemLink> selectByExample(MarketingItemLinkExample marketingItemLinkExample);

    public MarketingItemLink selectByPrimaryKey(MarketingItemLinkKey marketingItemLinkKey);

}
