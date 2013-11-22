package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.MarketingView;
import com.gooagoo.entity.generator.marketing.MarketingViewExample;
import com.gooagoo.entity.generator.marketing.MarketingViewKey;

public interface MarketingViewMapper
{

    public Integer countByExample(MarketingViewExample marketingViewExample);

    public List<MarketingView> selectByExample(MarketingViewExample marketingViewExample);

    public MarketingView selectByPrimaryKey(MarketingViewKey marketingViewKey);

}
