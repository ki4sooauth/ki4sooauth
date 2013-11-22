package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.marketing.MarketingActivityKey;

public interface MarketingActivityMapper
{

    public Integer countByExample(MarketingActivityExample marketingActivityExample);

    public List<MarketingActivity> selectByExample(MarketingActivityExample marketingActivityExample);

    public MarketingActivity selectByPrimaryKey(MarketingActivityKey marketingActivityKey);

    public Integer deleteByExample(MarketingActivityExample marketingActivityExample);

    public Integer deleteByPrimaryKey(MarketingActivityKey marketingActivityKey);

    public Integer insertSelective(MarketingActivity marketingActivity);

    public Integer updateAllByExample(@Param("record") MarketingActivity marketingActivity, @Param("example") MarketingActivityExample marketingActivityExample);

    public Integer updateByExampleSelective(@Param("record") MarketingActivity marketingActivity, @Param("example") MarketingActivityExample marketingActivityExample);

    public Integer updateByPrimaryKeySelective(MarketingActivity marketingActivity);

}
