package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.MarketingEventExample;
import com.gooagoo.entity.generator.marketing.MarketingEventKey;

public interface MarketingEventMapper
{

    public Integer countByExample(MarketingEventExample marketingEventExample);

    public List<MarketingEvent> selectByExample(MarketingEventExample marketingEventExample);

    public MarketingEvent selectByPrimaryKey(MarketingEventKey marketingEventKey);

    public Integer deleteByExample(MarketingEventExample marketingEventExample);

    public Integer deleteByPrimaryKey(MarketingEventKey marketingEventKey);

    public Integer insertSelective(MarketingEvent marketingEvent);

    public Integer updateAllByExample(@Param("record") MarketingEvent marketingEvent, @Param("example") MarketingEventExample marketingEventExample);

    public Integer updateByExampleSelective(@Param("record") MarketingEvent marketingEvent, @Param("example") MarketingEventExample marketingEventExample);

    public Integer updateByPrimaryKeySelective(MarketingEvent marketingEvent);

}
