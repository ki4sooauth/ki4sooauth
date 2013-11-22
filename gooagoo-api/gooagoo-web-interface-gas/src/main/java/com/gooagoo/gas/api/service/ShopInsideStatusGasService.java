package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gasb01.transform.StoreMainAreaRoot;

/**
 * 店内状态接口
 */
public interface ShopInsideStatusGasService
{
    /**
     * 查询商家区域人数（用于接口gasb01）
     * @param shopEntityid
     * @param positionId
     * @return
     * @throws Exception
     */
    public StoreMainAreaRoot queryAreaPeopleNums(String shopEntityid, String positionId) throws Exception;
}
