package com.gooagoo.api.protecteds.query.shop;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.shop.ShopEntityInfoBusiness;

public interface ShopProtectedQueryService
{

    /**
     * 定位实体店
     * 根据商家ID、实体店lid定位实体店
     * 若lid不在商家名下或lid未传入，则返回商家名下lidbase最小（lidbase最小表示总店）的实体店编号
     * @param shopId
     * @param lid
     * @return
     */
    public String getShopEntity(String shopId, String lid);

    /**
     * 根据当前商家类型获取其下属商家类型
     * @param shopTypeIdList
     * @param shoptypeId
     */
    public void getShopTypeIdByRecursion(List<String> shopTypeIdList, String shoptypeId);

    /**
     * 根据商家类型查询所属 其下属商家类型及当前商家类型的商家编号
     * @param shopTypeId 商家类型编号
     * @return
     */
    public List<String> getShopIdByShopType(String shopTypeId);

    /**
     * 查询(起菜/催菜/缓菜/重量/开台/换台/并台/撤台/勾挑)
     * @param mac
     * @param shopEntityId
     * @param ctimestamp
     * @param type(0:起菜、1:催菜、2:缓菜、3:重量、4:开台、5:换台、6:并台、7:撤台、8:勾挑)
     * @return
     */
    public List<Map<String, String>> findByType(String mac, String shopEntityId, String ctimestamp, String type);

    /**
     * 获取商家主店（每个商家只有一个总店）信息
     * @param shopId 商家编号
     * @return
     */
    public ShopEntityInfoBusiness getTheMainShopInfo(String shopId);
}
