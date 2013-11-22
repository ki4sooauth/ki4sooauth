package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.TradeAreaGeneratorQueryService;
import com.gooagoo.entity.generator.sys.TradeArea;
import com.gooagoo.entity.generator.sys.TradeAreaExample;
import com.gooagoo.entity.generator.sys.TradeAreaKey;
import com.gooagoo.dao.generator.sys.TradeAreaMapper;

@Service
public class TradeAreaGeneratorQueryServiceImpl implements TradeAreaGeneratorQueryService
{

    @Autowired
    private TradeAreaMapper tradeAreaMapper;

    @Override
    public Integer countByExample(TradeAreaExample tradeAreaExample) 
    {
        return this.tradeAreaMapper.countByExample(tradeAreaExample);
    }

    @Override
    public List<TradeArea> selectByExample(TradeAreaExample tradeAreaExample) 
    {
        return this.tradeAreaMapper.selectByExample(tradeAreaExample);
    }

    @Override
    public TradeArea selectUnDelByPrimaryKey(String primaryKey) 
    {
        TradeAreaKey tradeAreaKey = new TradeAreaKey();
        tradeAreaKey.setIsDel("N");
        tradeAreaKey.setTradeAreaId(primaryKey);
        return this.tradeAreaMapper.selectByPrimaryKey(tradeAreaKey);
    }

    @Override
    public TradeArea selectByPrimaryKey(String primaryKey) 
    {
        TradeAreaKey tradeAreaKey = new TradeAreaKey();
        tradeAreaKey.setTradeAreaId(primaryKey);
        return this.tradeAreaMapper.selectByPrimaryKey(tradeAreaKey);
    }

}
