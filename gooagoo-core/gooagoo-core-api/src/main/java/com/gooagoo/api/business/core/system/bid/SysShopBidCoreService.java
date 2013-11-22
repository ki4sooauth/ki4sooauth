package com.gooagoo.api.business.core.system.bid;

import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.ShopBid;
import com.gooagoo.exception.business.shop.ShopAdDeletedOrNotExistException;
import com.gooagoo.exception.business.shop.ShopBidAmountLackException;
import com.gooagoo.exception.business.shop.ShopBidTimeInvalidException;

/**
 * 商家竞拍
 */
public interface SysShopBidCoreService
{

    /**
     * 商家竞价
     * @param shopBid 商家竞拍信息
     * @return
     * @throws ShopAdDeletedOrNotExistException 广告位不存在或已删除异常异常
     * @throws ShopBidTimeInvalidException 商家竞拍时间无效异常
     * @throws ShopBidAmountLackException 商家竞拍金额不足异常
     */
    public boolean shopBidding(ShopBid shopBid) throws Exception;

    /**
     * 新建广告位管理
     * @param adsManage 广告位管理
     * @return
     * @throws Exception
     */
    public boolean addAdsManage(AdsManage adsManage) throws Exception;

    /**
     * 修改广告位管理
     * @param adsManage 广告位管理
     * @return
     * @throws Exception
     */
    public boolean updateAdsManage(AdsManage adsManage) throws Exception;

    /**
     * 修改广告位管理状态
     * @param bidIds 竞拍编号多个用逗号分隔
     * @param state 状态
     * @return
     * @throws Exception
     */
    public boolean updateAdsManageState(String bidIds, String state) throws Exception;

    /**
     * 批量删除广告位管理
     * @param bidIds 竞拍编号多个逗号分隔
     * @return
     * @throws Exception
     */
    public boolean deleteAdsManage(String bidIds) throws Exception;

    /**
     * 竞拍活动跑批
     * @param bidIdlist 竞拍编号列表
     * @return
     * @throws Exception
     */
    public boolean batchShopBid(AdsManage adsManage) throws Exception;

}
