package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.TradeArea;
import com.gooagoo.entity.generator.sys.TradeAreaExample;
import com.gooagoo.entity.generator.sys.TradeAreaKey;

public interface TradeAreaMapper
{

    public Integer countByExample(TradeAreaExample tradeAreaExample);

    public List<TradeArea> selectByExample(TradeAreaExample tradeAreaExample);

    public TradeArea selectByPrimaryKey(TradeAreaKey tradeAreaKey);

    public Integer deleteByExample(TradeAreaExample tradeAreaExample);

    public Integer deleteByPrimaryKey(TradeAreaKey tradeAreaKey);

    public Integer insertSelective(TradeArea tradeArea);

    public Integer updateAllByExample(@Param("record") TradeArea tradeArea, @Param("example") TradeAreaExample tradeAreaExample);

    public Integer updateByExampleSelective(@Param("record") TradeArea tradeArea, @Param("example") TradeAreaExample tradeAreaExample);

    public Integer updateByPrimaryKeySelective(TradeArea tradeArea);

}
