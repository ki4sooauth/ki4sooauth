package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.MarketingView;
import com.gooagoo.entity.generator.marketing.MarketingViewExample;
import com.gooagoo.entity.generator.marketing.MarketingViewKey;

public interface MarketingViewMapper
{

    public Integer countByExample(MarketingViewExample marketingViewExample);

    public List<MarketingView> selectByExample(MarketingViewExample marketingViewExample);

    public MarketingView selectByPrimaryKey(MarketingViewKey marketingViewKey);

    public Integer deleteByExample(MarketingViewExample marketingViewExample);

    public Integer deleteByPrimaryKey(MarketingViewKey marketingViewKey);

    public Integer insertSelective(MarketingView marketingView);

    public Integer updateAllByExample(@Param("record") MarketingView marketingView, @Param("example") MarketingViewExample marketingViewExample);

    public Integer updateByExampleSelective(@Param("record") MarketingView marketingView, @Param("example") MarketingViewExample marketingViewExample);

    public Integer updateByPrimaryKeySelective(MarketingView marketingView);

}
