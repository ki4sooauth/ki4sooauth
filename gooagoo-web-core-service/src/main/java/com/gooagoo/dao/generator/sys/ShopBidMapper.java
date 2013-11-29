package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.entity.generator.sys.ShopBidExample;
import com.gooagoo.entity.generator.sys.ShopBidKey;

public interface ShopBidMapper
{

    public Integer countByExample(ShopBidExample shopBidExample);

    public List<ShopBid> selectByExample(ShopBidExample shopBidExample);

    public ShopBid selectByPrimaryKey(ShopBidKey shopBidKey);

    public Integer deleteByExample(ShopBidExample shopBidExample);

    public Integer deleteByPrimaryKey(ShopBidKey shopBidKey);

    public Integer insertSelective(ShopBid shopBid);

    public Integer updateAllByExample(@Param("record") ShopBid shopBid, @Param("example") ShopBidExample shopBidExample);

    public Integer updateByExampleSelective(@Param("record") ShopBid shopBid, @Param("example") ShopBidExample shopBidExample);

    public Integer updateByPrimaryKeySelective(ShopBid shopBid);

}
