package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gasd01.transform.CategoryRoot;
import com.gooagoo.gas.entity.gasd02.transform.QueryGoodsListRoot;

/**
 * 商品查询接口
 */
public interface GoodsGasService
{
    /**
     * 接口gasd01:店员查询商家商品品类
     * @param shopEntityId 商家编码
     * @param pageIndex 页码
     * @param pageSize 每页显示信息条数
     * @return
     * @throws Exception
     */
    public CategoryRoot queryGoodsCategoryInfo(String shopEntityId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gasd02:店员按商品品类查询商品列表
     * @param shopEntityId 实体店编号
     * @param categoryId 品类编号
     * @param pageIndex 页码
     * @param pageSize 每页显示信息条数
     * @return
     * @throws Exception
     */
    public QueryGoodsListRoot queryGoodsInfoBySort(String shopId, String shopEntityId, String categoryId, String pageIndex, String pageSize) throws Exception;
}
