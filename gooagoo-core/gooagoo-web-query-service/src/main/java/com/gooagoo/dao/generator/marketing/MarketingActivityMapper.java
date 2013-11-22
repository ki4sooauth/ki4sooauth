package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.marketing.MarketingActivityKey;

public interface MarketingActivityMapper
{

    public Integer countByExample(MarketingActivityExample marketingActivityExample);

    public List<MarketingActivity> selectByExample(MarketingActivityExample marketingActivityExample);

    public MarketingActivity selectByPrimaryKey(MarketingActivityKey marketingActivityKey);

}
