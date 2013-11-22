package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.entity.generator.sys.ShopBidExample;
import com.gooagoo.entity.generator.sys.ShopBidKey;

public interface ShopBidMapper
{

    public Integer countByExample(ShopBidExample shopBidExample);

    public List<ShopBid> selectByExample(ShopBidExample shopBidExample);

    public ShopBid selectByPrimaryKey(ShopBidKey shopBidKey);

}
