package com.gooagoo.api.business.query.marketing.cryout;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfo;
import com.gooagoo.entity.business.marketing.cryout.ShopCryoutInfoBusiness;

public class TestCryoutQueryService
{

    public CryoutQueryService cryoutQueryService;

    @Before
    public void testBefore()
    {
        this.cryoutQueryService = ApplicationContextUtils.getBean(CryoutQueryService.class);
    }

    /**
     * 查询商家吆喝
     * @throws Exception
     */
    @Test
    public void testFindCryoutList() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";
        String shopId = null;
        String shopType = "C";
        String cryoutType = null;
        String pageId = "0";
        String pageType = "P";
        Integer pageSize = 30;
        String cTimeStamp = "2013-10-14 17:49:40";
        ShopCryoutInfoBusiness shopCryoutInfoBusiness = this.cryoutQueryService.findCryoutList("M", userId, shopId, shopType, cryoutType, pageId, pageType, pageSize, cTimeStamp);
        List<ShopCryoutInfo> list = shopCryoutInfoBusiness.getShopCryoutInfoList();
        for (ShopCryoutInfo item : list)
        {
            System.out.println(item.getPageId());
        }
        Assert.assertNotNull("查询商家吆喝失败", shopCryoutInfoBusiness);
    }

    /**
     * 6.4.10. 他们在说（通过模型分析）
     * @throws Exception
     */
    @Test
    public void testFindCryoutOther() throws Exception
    {
        String userId = "01822RBQ22JSDMA085QBV8EIISWR0JGT";//01822N0IJLPA8N700C5V4PBJ43P1R5JO
        List<ShopCryoutInfo> shopCryoutInfoList = this.cryoutQueryService.findCryoutOther(userId);
        Assert.assertTrue("他们在说（通过模型分析）失败", CollectionUtils.isNotEmpty(shopCryoutInfoList));
    }

    /**
     * 获取推荐给指定用户的吆喝列表
     * @throws Exception
     */
    @Test
    public void testFindRecommendCryOut() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}
