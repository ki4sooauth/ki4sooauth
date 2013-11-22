package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.base.MarketingChannel;

/**
 *  营销渠道字典表管理
 */
public interface MarketingChannelsDicCoreService

{

    /**
     * 新增营销渠道
     * @param marketingChannel
     * @return
     * @throws Exception
     */
    public boolean addMarketingChannelsDic(MarketingChannel marketingChannel) throws Exception;

    /**
     * 编辑营销渠道
     * @param marketingChannel
     * @return
     * @throws Exception
     */
    public boolean updateMarketingChannelsDic(MarketingChannel marketingChannel) throws Exception;

    /**
     * 删除营销渠道
     * @param channelCode
     * @return
     * @throws Exception
     */
    public boolean delMarketingChannelsDic(String channelCode) throws Exception;

    /**
     * 批量新增营销渠道（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllMarketingChannelsDic(List<MarketingChannel> sysList) throws Exception;

}
