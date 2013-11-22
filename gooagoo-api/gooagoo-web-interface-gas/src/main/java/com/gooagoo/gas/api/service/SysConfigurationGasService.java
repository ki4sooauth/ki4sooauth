package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gasn01.transform.FindShopBaseInfoRoot;

public interface SysConfigurationGasService
{
    /**
     * 接口gasn01:查询商家基本信息同步接口
     * @param shopId 商家编号
     * @param goodsId 商品编号
     * @return
     * @throws Exception
     */
    public FindShopBaseInfoRoot findShopBaseInfo(String shopId, String goodsId) throws Exception;
}
