package com.gooagoo.api.protecteds.query.goods;

import java.util.List;

import com.gooagoo.exception.GooagooException;

public interface GoodsProtectedQueryService
{

    /**
     * 根据品类编号获取所有子类品列表(包含本身)
     * @param shopEntityId
     * @param parentCategoryId
     * @return
     * @throws GooagooException
     */
    public List<String> findGoodsCategoryListByParent(String shopEntityId, String parentCategoryId) throws GooagooException;

}
