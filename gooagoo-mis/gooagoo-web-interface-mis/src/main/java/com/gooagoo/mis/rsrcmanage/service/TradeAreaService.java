package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.systemHierarchy.MTradeArea;

public interface TradeAreaService
{
    /**
     * 新增商圈信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addTradeArea(HttpServletRequest request) throws Exception;

    /**
     * 删除商圈信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> deleteTradeArea(HttpServletRequest request) throws Exception;

    /**
     * 查询商圈详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MTradeArea> queryTradeAreaInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改商圈信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateTradeArea(HttpServletRequest request) throws Exception;

    /**
     * 查询所有商圈信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MTradeArea>> queryTradeAreaList(HttpServletRequest request) throws Exception;
}
