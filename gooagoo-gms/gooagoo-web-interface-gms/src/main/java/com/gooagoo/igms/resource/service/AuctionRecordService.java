package com.gooagoo.igms.resource.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.resource.AllBiddingRecordView;
import com.gooagoo.view.gms.resource.ShopBiddingRecordView;
import com.gooagoo.view.gms.resource.WinBiddingRecordView;

public interface AuctionRecordService
{

    /**
     * 分页查询所有商家的竞拍记录
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<PageModel<AllBiddingRecordView>> pageAllBiddingRecord(HttpServletRequest request) throws Exception;

    /**
     * 分页查询指定广告位竞拍成功的计录
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<PageModel<WinBiddingRecordView>> pageWinBiddingRecord(HttpServletRequest request) throws Exception;

    /**
     * 分页查询指定广告位当前商家竞拍记录
     * @param request
     * @return
     * @throws Exception 
     */
    public TransData<PageModel<ShopBiddingRecordView>> pageShopBiddingRecord(HttpServletRequest request) throws Exception;

}
