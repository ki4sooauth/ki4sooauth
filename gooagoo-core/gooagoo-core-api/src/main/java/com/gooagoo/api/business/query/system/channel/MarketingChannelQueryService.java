package com.gooagoo.api.business.query.system.channel;

import java.util.List;

import com.gooagoo.entity.generator.base.MarketingChannel;

public interface MarketingChannelQueryService
{

    /**
     * 根据父类查询所有子类渠道列表
     * @param parentId
     * @return
     * @throws Exception
     */
    public List<MarketingChannel> findMarketingChannelListByParent(String parentId) throws Exception;

}
