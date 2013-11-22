package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gask01.transform.GetFoodByIdRoot;
import com.gooagoo.gas.entity.gask02.transform.GetDishCategoryRoot;
import com.gooagoo.gas.entity.gask03.transform.GetCategoryByDeskNoRoot;

public interface DishLinkService
{
    /**
     * 接口gask01:店员按菜品名称或自定义序列号查询菜品信息
     * @param shopEntityId 实体店编号
     * @param foodName  菜品名称或者编号
     * @param pageIndex 页码
     * @param pageSize  每页信息显示条数
     * @return
     * @throws Exception
     */
    public GetFoodByIdRoot queryFoodsInfoByIdOrName(String shopEntityId, String foodName, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gask02:店员查询菜品各类别根节点
     * @param shopEntityId 实体店编号
     * @param pageIndex 页码
     * @param pageSize  每页信息显示条数
     * @return
     * @throws Exception
     */
    public GetDishCategoryRoot queryRootFoodCategory(String shopEntityId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gask03:店员按菜品类别编号查询菜品信息
     * @param shopEntityId 实体店编号
     * @param categoryId 品类编号
     * @param pageIndex 页码
     * @param pageSize  每页信息显示条数
     * @return
     * @throws Exception
     */
    public GetCategoryByDeskNoRoot queryFoodsInfoByCategory(String shopEntityId, String categoryId, String pageIndex, String pageSize) throws Exception;

}
