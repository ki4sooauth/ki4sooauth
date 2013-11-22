package com.gooagoo.api.business.core.shop.position;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopPosition;

public interface ShopPositionCoreService
{
    /**
     * 添加位置
     * @param shopPosition
     * @return true/false
     * @throws Exception
     */
    public boolean addShopPosition(ShopPosition shopPosition) throws Exception;

    /**
     * 修改位置
     * @param shopPosition
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopPosition(ShopPosition shopPosition) throws Exception;

    /**
     * 删除位置
     * @param Id
     * @return true/false
     * @throws Exception
     */
    public boolean deleteShopPosition(String Id) throws Exception;

    /**
     * 导入商家位置信息(入库前，将此实体店的位置信息全部逻辑删除)
     * @param shopEntityId
     * @param shopPositionList
     * @throws Exception
     */
    public void importShopPosition(String shopEntityId, List<ShopPosition> shopPositionList) throws Exception;

}
