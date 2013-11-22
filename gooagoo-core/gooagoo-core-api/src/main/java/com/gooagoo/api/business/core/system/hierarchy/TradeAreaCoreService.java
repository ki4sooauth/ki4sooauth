package com.gooagoo.api.business.core.system.hierarchy;

import com.gooagoo.entity.generator.sys.TradeArea;

/**
 *  系统层级管理:商圈
 */
public interface TradeAreaCoreService
{

    /**
     * 新增商圈信息
     * @param tradeArea
     * @return True/False
     * @throws Exception
     */
    public boolean addTradeArea(TradeArea tradeArea) throws Exception;

    /**
     * 更新商圈信息
     * @param tradeArea
     * @return True/False
     * @throws Exception
     */
    public boolean updateTradeArea(TradeArea tradeArea) throws Exception;

    /**
     * 删除商圈信息
     * @param tradeAreaIds 商圈编号(多个用逗号分隔)
     * @return True/False
     * @throws Exception
     */
    public boolean deleteTradeArea(String tradeAreaIds) throws Exception;

}
