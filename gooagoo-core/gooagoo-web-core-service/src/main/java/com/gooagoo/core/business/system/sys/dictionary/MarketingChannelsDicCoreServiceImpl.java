package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.MarketingChannelsDicCoreService;
import com.gooagoo.api.generator.core.base.MarketingChannelGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.MarketingChannel;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class MarketingChannelsDicCoreServiceImpl implements MarketingChannelsDicCoreService

{

    @Autowired
    private MarketingChannelGeneratorCoreService marketingChannelGeneratorCoreService;

    @Override
    public boolean addMarketingChannelsDic(MarketingChannel marketingChannel) throws Exception
    {
        marketingChannel.setIsDel("N");
        return this.marketingChannelGeneratorCoreService.insertSelective(marketingChannel);
    }

    @Override
    public boolean updateMarketingChannelsDic(MarketingChannel marketingChannel) throws Exception
    {
        return this.marketingChannelGeneratorCoreService.updateByPrimaryKeySelective(marketingChannel);
    }

    @Override
    public boolean delMarketingChannelsDic(String channelCode) throws Exception
    {
        MarketingChannel marketingChannel = new MarketingChannel();
        marketingChannel.setChannelCode(Integer.parseInt(channelCode));
        marketingChannel.setIsDel("Y");
        return this.marketingChannelGeneratorCoreService.updateByPrimaryKeySelective(marketingChannel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllMarketingChannelsDic(List<MarketingChannel> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.marketingChannelGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空营销渠道表失败");
            throw new OperateFailException("清空营销渠道表失败");
        }
        for (MarketingChannel inter : sysList)
        {
            if (!this.marketingChannelGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增营销渠道失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
