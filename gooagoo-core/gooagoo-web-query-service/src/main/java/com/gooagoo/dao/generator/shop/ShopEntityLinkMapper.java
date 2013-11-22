package com.gooagoo.dao.generator.shop;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopEntityLinkExample;
import com.gooagoo.entity.generator.shop.ShopEntityLinkKey;

public interface ShopEntityLinkMapper
{

    public Integer countByExample(ShopEntityLinkExample shopEntityLinkExample);

    public List<ShopEntityLink> selectByExample(ShopEntityLinkExample shopEntityLinkExample);

    public ShopEntityLink selectByPrimaryKey(ShopEntityLinkKey shopEntityLinkKey);

}
