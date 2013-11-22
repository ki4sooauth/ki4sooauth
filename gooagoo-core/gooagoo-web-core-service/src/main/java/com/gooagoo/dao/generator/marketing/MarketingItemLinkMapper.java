package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.MarketingItemLink;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingItemLinkKey;

public interface MarketingItemLinkMapper
{

    public Integer countByExample(MarketingItemLinkExample marketingItemLinkExample);

    public List<MarketingItemLink> selectByExample(MarketingItemLinkExample marketingItemLinkExample);

    public MarketingItemLink selectByPrimaryKey(MarketingItemLinkKey marketingItemLinkKey);

    public Integer deleteByExample(MarketingItemLinkExample marketingItemLinkExample);

    public Integer deleteByPrimaryKey(MarketingItemLinkKey marketingItemLinkKey);

    public Integer insertSelective(MarketingItemLink marketingItemLink);

    public Integer updateAllByExample(@Param("record") MarketingItemLink marketingItemLink, @Param("example") MarketingItemLinkExample marketingItemLinkExample);

    public Integer updateByExampleSelective(@Param("record") MarketingItemLink marketingItemLink, @Param("example") MarketingItemLinkExample marketingItemLinkExample);

    public Integer updateByPrimaryKeySelective(MarketingItemLink marketingItemLink);

}
