package com.gooagoo.dao.business.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.shop.map.MappositionlistBusiness;

public interface ShopEntityInfoAdapterMapper
{
    /**
     * 按实体店编号和实体店名称模糊查询实体店关联信息（实体店编号、实体店名称、查询信息类型、 svg x坐标、svg y坐标）
     * @param entityIds 实体店编号
     * @param name 实体店名称
     * @return
     */
    public List<MappositionlistBusiness> getShopEntityLinkInfo(@Param("entityIds") List<String> entityIds, @Param("name") String name);

    /**
     * 按实体店编号和商品名称模糊查询商品和实体店关联信息（商品编号、商品名称、查询信息类型、 svg x坐标、svg y坐标）
     * @param entityIds
     * @param name
     * @return
     */
    public List<MappositionlistBusiness> getGoodsLinkShopEntityInfo(@Param("entityIds") List<String> entityIds, @Param("name") String name);
}
