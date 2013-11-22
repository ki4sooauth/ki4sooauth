package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingEventExample;
import com.gooagoo.entity.generator.marketing.MarketingEventKey;

public interface MarketingEventMapper
{

    public Integer countByExample(MarketingEventExample marketingEventExample);

    public List<MarketingEvent> selectByExample(MarketingEventExample marketingEventExample);

    public MarketingEvent selectByPrimaryKey(MarketingEventKey marketingEventKey);

}
