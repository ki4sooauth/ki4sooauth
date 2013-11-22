package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.TradeArea;
import com.gooagoo.entity.generator.sys.TradeAreaExample;
import com.gooagoo.entity.generator.sys.TradeAreaKey;

public interface TradeAreaMapper
{

    public Integer countByExample(TradeAreaExample tradeAreaExample);

    public List<TradeArea> selectByExample(TradeAreaExample tradeAreaExample);

    public TradeArea selectByPrimaryKey(TradeAreaKey tradeAreaKey);

}
