package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gash01.transform.IntercomRoot;

/**
 * 对讲机
 */
public interface IntercomGasService
{
    /**
     * 接口gash01:查询本实体店的店员列表
     * @param shopEntityId 实体店编号
     * @return
     * @throws Exception
     */
    public IntercomRoot queryShopPositionInfos(String shopEntityId) throws Exception;

}
