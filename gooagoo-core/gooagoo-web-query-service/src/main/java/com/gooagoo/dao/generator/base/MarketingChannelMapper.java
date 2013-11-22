package com.gooagoo.dao.generator.base;

import java.util.List;

import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.MarketingChannelExample;
import com.gooagoo.entity.generator.base.MarketingChannelKey;

public interface MarketingChannelMapper
{

    public Integer countByExample(MarketingChannelExample marketingChannelExample);

    public List<MarketingChannel> selectByExample(MarketingChannelExample marketingChannelExample);

    public MarketingChannel selectByPrimaryKey(MarketingChannelKey marketingChannelKey);

}
