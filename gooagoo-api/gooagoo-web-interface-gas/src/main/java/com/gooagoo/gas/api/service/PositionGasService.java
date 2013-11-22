package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gasf01.transform.GetPositionRoot;

/**
 * 位置布局
 */
public interface PositionGasService
{
    /**
     * 接口gasf01:位置布局
     * @param shopEntityId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public GetPositionRoot queryShopPositionInfos(String shopEntityId, String pageIndex, String pageSize) throws Exception;
}
