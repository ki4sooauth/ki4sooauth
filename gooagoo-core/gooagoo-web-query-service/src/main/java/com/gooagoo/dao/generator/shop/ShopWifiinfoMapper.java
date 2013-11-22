package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopWifiinfo;
import com.gooagoo.entity.generator.shop.ShopWifiinfoExample;
import com.gooagoo.entity.generator.shop.ShopWifiinfoKey;

public interface ShopWifiinfoMapper
{

    public Integer countByExample(ShopWifiinfoExample shopWifiinfoExample);

    public List<ShopWifiinfo> selectByExample(ShopWifiinfoExample shopWifiinfoExample);

    public ShopWifiinfo selectByPrimaryKey(ShopWifiinfoKey shopWifiinfoKey);

}
