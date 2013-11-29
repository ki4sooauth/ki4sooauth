package com.gooagoo.dao.generator.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopEntityLinkExample;
import com.gooagoo.entity.generator.shop.ShopEntityLinkKey;

public interface ShopEntityLinkMapper
{

    public Integer countByExample(ShopEntityLinkExample shopEntityLinkExample);

    public List<ShopEntityLink> selectByExample(ShopEntityLinkExample shopEntityLinkExample);

    public ShopEntityLink selectByPrimaryKey(ShopEntityLinkKey shopEntityLinkKey);

    public Integer deleteByExample(ShopEntityLinkExample shopEntityLinkExample);

    public Integer deleteByPrimaryKey(ShopEntityLinkKey shopEntityLinkKey);

    public Integer insertSelective(ShopEntityLink shopEntityLink);

    public Integer updateAllByExample(@Param("record") ShopEntityLink shopEntityLink, @Param("example") ShopEntityLinkExample shopEntityLinkExample);

    public Integer updateByExampleSelective(@Param("record") ShopEntityLink shopEntityLink, @Param("example") ShopEntityLinkExample shopEntityLinkExample);

    public Integer updateByPrimaryKeySelective(ShopEntityLink shopEntityLink);

}
