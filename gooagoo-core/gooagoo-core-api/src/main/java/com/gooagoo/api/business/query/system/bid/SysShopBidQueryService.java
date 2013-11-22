package com.gooagoo.api.business.query.system.bid;

import java.util.List;

import com.gooagoo.entity.business.system.bid.BidDetailInfo;
import com.gooagoo.entity.business.system.bid.BidDetailInfoBusiness;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.AdsManageExample;

/**
 * 商家竞拍
 */
public interface SysShopBidQueryService
{

    /**
     * 查询广告位的竞拍历史记录
     * @param adcode 广告位编码
     * @param type 查询类型(A-所有商家，S-登录商家)
     * @param shopId 商家编号(type=S时必填)
     * @return BidDetailInfoBusiness
     * @throws Exception
     */
    public BidDetailInfoBusiness findAdBidHistory(String adCode, String type, String shopId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 查询商家的竞拍历史记录
     * @param shopId 商家编号
     * @param pageIndex
     * @param pageSize
     * @return BidDetailInfoBusiness
     * @throws Exception
     */
    public BidDetailInfoBusiness findShopBidHistory(String shopId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 获取广告信息
     * @param adcode 广告位编码
     * @return AdsManage
     * @throws Exception
     */
    public AdsManage findAdvertsManage(String adcode) throws Exception;

    /**
     * 查询所有广告位信息
     * @param adsManageExample 广告位管理过滤器
     * @return List<BidDetailInfo>
     * @throws Exception
     */
    public List<BidDetailInfo> findAllShopAd(AdsManageExample adsManageExample) throws Exception;

}
