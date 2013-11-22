package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopLidDetailExample;
import com.gooagoo.entity.generator.shop.ShopLidDetailKey;

public interface ShopLidDetailMapper
{

    public Integer countByExample(ShopLidDetailExample shopLidDetailExample);

    public List<ShopLidDetail> selectByExample(ShopLidDetailExample shopLidDetailExample);

    public ShopLidDetail selectByPrimaryKey(ShopLidDetailKey shopLidDetailKey);

}
