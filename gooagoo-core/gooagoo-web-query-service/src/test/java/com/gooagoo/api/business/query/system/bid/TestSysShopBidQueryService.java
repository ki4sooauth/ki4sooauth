package com.gooagoo.api.business.query.system.bid;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.system.bid.BidDetailInfoBusiness;
import com.gooagoo.entity.generator.sys.AdsManage;

public class TestSysShopBidQueryService
{

    public SysShopBidQueryService sysShopBidQueryService;

    @Before
    public void testBefore()
    {
        this.sysShopBidQueryService = ApplicationContextUtils.getBean(SysShopBidQueryService.class);
    }

    /**
     * 查询广告位的竞拍历史记录
     * @throws Exception
     */
    @Test
    public void testFindAdBidHistory() throws Exception
    {
        String adCode = "10101";
        String type = "S";
        String shopId = "01822R97QK2FRDT085QBV2EIISWR0JGT";
        Integer pageIndex = null;
        Integer pageSize = null;
        BidDetailInfoBusiness bidDetailInfoBusiness = this.sysShopBidQueryService.findAdBidHistory(adCode, type, shopId, pageIndex, pageSize);
        Assert.assertNotNull("查询商家的竞拍历史记录失败", bidDetailInfoBusiness);
    }

    /**
     * 查询商家的竞拍历史记录
     * @throws Exception
     */
    @Test
    public void testFindShopBidHistory() throws Exception
    {
        String shopId = "01822R97QK2FRDT085QBV2EIISWR0JGT";
        Integer pageIndex = null;
        Integer pageSize = null;
        BidDetailInfoBusiness bidDetailInfoBusiness = this.sysShopBidQueryService.findShopBidHistory(shopId, pageIndex, pageSize);
        Assert.assertNotNull("查询商家的竞拍历史记录失败", bidDetailInfoBusiness);
    }

    /**
     * 查询商家的竞拍历史记录
     * @throws Exception
     */
    @Test
    public void testFindAdvertsManage() throws Exception
    {
        String adcode = "10102";
        AdsManage adsManage = this.sysShopBidQueryService.findAdvertsManage(adcode);
        Assert.assertNotNull("查询商家的竞拍历史记录失败", adsManage);
    }

}
