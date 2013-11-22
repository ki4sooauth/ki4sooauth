package com.gooagoo.api.business.query.user.shoppingmatch;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;

public class TestShoppingMatchQueryService
{

    public ShoppingMatchQueryService shoppingMatchQueryService;

    @Before
    public void testBefore()
    {
        this.shoppingMatchQueryService = ApplicationContextUtils.getBean(ShoppingMatchQueryService.class);
    }

    /**
     * mobd08
     * @throws Exception
     */
    @Test
    public void testShoppingMatch() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * mobd02
     * @throws Exception
     */
    @Test
    public void testGetMatchgoodslistInfo() throws Exception
    {
        String goodsids = "00017R7HS2DC532E1001MHEIISX8Q023,00017R7KNBC3P3LH6003A4EIISX8Q023,00017R7KQQCU0K6J0003BPEIISX8Q023";
        List<ShopGoodsDetailInfo> shopGoodsDetailInfoList = this.shoppingMatchQueryService.getMatchgoodslistInfo(goodsids);
        Assert.assertTrue("查询购物匹配（商品详细信息）失败", CollectionUtils.isNotEmpty(shopGoodsDetailInfoList));
    }

}
