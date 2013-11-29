package com.gooagoo.dao.generator.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.entity.generator.base.MarketingChannelExample;
import com.gooagoo.entity.generator.base.MarketingChannelKey;

public interface MarketingChannelMapper
{

    public Integer countByExample(MarketingChannelExample marketingChannelExample);

    public List<MarketingChannel> selectByExample(MarketingChannelExample marketingChannelExample);

    public MarketingChannel selectByPrimaryKey(MarketingChannelKey marketingChannelKey);

    public Integer deleteByExample(MarketingChannelExample marketingChannelExample);

    public Integer deleteByPrimaryKey(MarketingChannelKey marketingChannelKey);

    public Integer insertSelective(MarketingChannel marketingChannel);

    public Integer updateAllByExample(@Param("record") MarketingChannel marketingChannel, @Param("example") MarketingChannelExample marketingChannelExample);

    public Integer updateByExampleSelective(@Param("record") MarketingChannel marketingChannel, @Param("example") MarketingChannelExample marketingChannelExample);

    public Integer updateByPrimaryKeySelective(MarketingChannel marketingChannel);

}
