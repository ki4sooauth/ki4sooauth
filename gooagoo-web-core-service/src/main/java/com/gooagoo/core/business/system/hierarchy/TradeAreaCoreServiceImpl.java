package com.gooagoo.core.business.system.hierarchy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.hierarchy.TradeAreaCoreService;
import com.gooagoo.api.generator.core.sys.TradeAreaGeneratorCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.sys.TradeArea;
import com.gooagoo.entity.generator.sys.TradeAreaExample;

@Service
public class TradeAreaCoreServiceImpl implements TradeAreaCoreService
{

    @Autowired
    private TradeAreaGeneratorCoreService tradeAreaGeneratorCoreService;

    @Override
    public boolean addTradeArea(TradeArea tradeArea) throws Exception
    {
        tradeArea.setTradeAreaId(UUID.getUUID());
        tradeArea.setIsDel("N");
        return this.tradeAreaGeneratorCoreService.insertSelective(tradeArea);
    }

    @Override
    public boolean updateTradeArea(TradeArea tradeArea) throws Exception
    {
        return this.tradeAreaGeneratorCoreService.updateByPrimaryKeySelective(tradeArea);
    }

    @Override
    public boolean deleteTradeArea(String tradeAreaIds) throws Exception
    {
        List<String> idList = Arrays.asList(tradeAreaIds.split(","));
        TradeAreaExample tradeAreaExample = new TradeAreaExample();
        tradeAreaExample.createCriteria().andTradeAreaIdIn(idList).andIsDelEqualTo("N");
        return this.tradeAreaGeneratorCoreService.deleteByExample(tradeAreaExample);
    }

}
