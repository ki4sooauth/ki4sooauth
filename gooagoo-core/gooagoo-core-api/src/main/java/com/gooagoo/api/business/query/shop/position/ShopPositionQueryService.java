package com.gooagoo.api.business.query.shop.position;

import java.util.List;

import com.gooagoo.entity.business.shop.MainAreaBusiness;
import com.gooagoo.entity.business.shop.position.ShopUserPositionBusiness;
import com.gooagoo.entity.generator.shop.ShopPosition;

public interface ShopPositionQueryService
{

    /**
     * 根据父类查询所有子类位置列表
     * @param shopId
     * @param shopEntityId
     * @param parentId
     * @return
     * @throws Exception
     */
    public List<ShopPosition> findShopPositionListByParent(String shopId, String shopEntityId, String parentId) throws Exception;

    /**
     * gasb01:查询商家区域人数
     * @param shopEntityId
     * @param positionId
     * @return
     * @throws Exception
     */
    public List<MainAreaBusiness> findShopPositionNumberOfPeople(String shopEntityId, String positionId) throws Exception;

    /**
     * 查询店员所属主区域信息
     * 商家编号必填
     * @param shopId
     * @param shopEntityId
     * @param brandId
     * @return 店员区域编号信息（店员有对应品牌，positionId为对应品牌的位置编号，店员无品牌时，对应的是实体店的主区域编号）
     * @throws Exception
     */
    public List<ShopUserPositionBusiness> getPositionOfShopUser(String shopId, String shopEntityId, String brandId) throws Exception;
}
