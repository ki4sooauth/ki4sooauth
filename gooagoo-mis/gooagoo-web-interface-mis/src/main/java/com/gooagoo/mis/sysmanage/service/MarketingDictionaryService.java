package com.gooagoo.mis.sysmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.dictionaryManage.MMarketingChannel;

public interface MarketingDictionaryService
{

    /**
     * 添加营销渠道字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> addMarketingDic(HttpServletRequest request) throws Exception;

    /**
     * 修改营销渠道字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> editMarketingDic(HttpServletRequest request) throws Exception;

    /**
     * 删除营销渠道字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<Object> delMarketingDic(HttpServletRequest request) throws Exception;

    /**
     * 查询营销渠道字典数据
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MMarketingChannel>> findMarketingChannelDict(HttpServletRequest request) throws Exception;

    /**
     * 查询营销渠道字典详细信息
     * @return
     * @throws GooagooException
     */
    public TransData<MMarketingChannel> findMarketingDetail(HttpServletRequest request) throws Exception;

    /**
     * 批量新增营销渠道字典
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addAllMarketingChannelDict(HttpServletRequest request) throws Exception;
    
}
