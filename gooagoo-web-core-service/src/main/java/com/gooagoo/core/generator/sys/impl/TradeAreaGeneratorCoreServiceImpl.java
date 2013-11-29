package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.TradeAreaGeneratorCoreService;
import com.gooagoo.entity.generator.sys.TradeArea;
import com.gooagoo.entity.generator.sys.TradeAreaExample;
import com.gooagoo.entity.generator.sys.TradeAreaKey;
import com.gooagoo.dao.generator.sys.TradeAreaMapper;

@Service
public class TradeAreaGeneratorCoreServiceImpl implements TradeAreaGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(TradeAreaExample tradeAreaExample) 
    {
        return this.tradeAreaMapper.deleteByExample(tradeAreaExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        TradeAreaKey tradeAreaKey = new TradeAreaKey();
        tradeAreaKey.setTradeAreaId(primaryKey);
        return this.tradeAreaMapper.deleteByPrimaryKey(tradeAreaKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(TradeAreaExample tradeAreaExample) 
    {
        TradeArea tradeArea = new TradeArea();
        tradeArea.setIsDel("Y");
        return this.tradeAreaMapper.updateByExampleSelective(tradeArea,tradeAreaExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        TradeArea tradeArea = new TradeArea();
        tradeArea.setTradeAreaId(primaryKey);
        tradeArea.setIsDel("Y");
        return this.tradeAreaMapper.updateByPrimaryKeySelective(tradeArea) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(TradeArea tradeArea) 
    {
        return this.tradeAreaMapper.insertSelective(tradeArea) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(TradeArea tradeArea,TradeAreaExample tradeAreaExample) 
    {
        return this.tradeAreaMapper.updateByExampleSelective(tradeArea,tradeAreaExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(TradeArea tradeArea) 
    {
        return this.tradeAreaMapper.updateByPrimaryKeySelective(tradeArea) > 0 ? true : false;
    }

}
