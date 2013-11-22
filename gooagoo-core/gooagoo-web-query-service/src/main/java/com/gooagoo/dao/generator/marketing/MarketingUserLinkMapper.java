package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkKey;

public interface MarketingUserLinkMapper
{

    public Integer countByExample(MarketingUserLinkExample marketingUserLinkExample);

    public List<MarketingUserLink> selectByExample(MarketingUserLinkExample marketingUserLinkExample);

    public MarketingUserLink selectByPrimaryKey(MarketingUserLinkKey marketingUserLinkKey);

}
