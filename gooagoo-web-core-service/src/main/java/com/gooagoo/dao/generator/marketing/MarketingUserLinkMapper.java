package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkExample;
import com.gooagoo.entity.generator.marketing.MarketingUserLinkKey;

public interface MarketingUserLinkMapper
{

    public Integer countByExample(MarketingUserLinkExample marketingUserLinkExample);

    public List<MarketingUserLink> selectByExample(MarketingUserLinkExample marketingUserLinkExample);

    public MarketingUserLink selectByPrimaryKey(MarketingUserLinkKey marketingUserLinkKey);

    public Integer deleteByExample(MarketingUserLinkExample marketingUserLinkExample);

    public Integer deleteByPrimaryKey(MarketingUserLinkKey marketingUserLinkKey);

    public Integer insertSelective(MarketingUserLink marketingUserLink);

    public Integer updateAllByExample(@Param("record") MarketingUserLink marketingUserLink, @Param("example") MarketingUserLinkExample marketingUserLinkExample);

    public Integer updateByExampleSelective(@Param("record") MarketingUserLink marketingUserLink, @Param("example") MarketingUserLinkExample marketingUserLinkExample);

    public Integer updateByPrimaryKeySelective(MarketingUserLink marketingUserLink);

}
