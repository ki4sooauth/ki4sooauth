package com.gooagoo.api.business.query.goods.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.business.goods.GoodsCategoryBusiness;
import com.gooagoo.entity.business.goods.GoodsContainComment;
import com.gooagoo.entity.business.goods.GoodsDetail;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;

public class TestGoodsQueryService
{

    public GoodsQueryService goodsQueryService;

    @Before
    public void testBefore()
    {
        this.goodsQueryService = ApplicationContextUtils.getBean(GoodsQueryService.class);
    }

    /**
     * 2.1.2. 根据商品Id查询商品基本信息详情
     * @throws Exception
     */
    @Test
    public void testFindGoodsBaseDetail() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 2.1.2. 根据商品Id查询商品营销信息详情
     * @throws Exception
     */
    @Test
    public void testFindGoodsMarketingDetail() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 2.1.2. 根据商品Id查询商品特征信息详情
     * @throws Exception
     */
    @Test
    public void testFindGoodsFeatureDetail() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 2.1.4. 根据自定义序列号、实体店编号、商家编号查询商品详情
     * @throws Exception
     */
    @Test
    public void testFindGoodsByItemSerial() throws Exception
    {
        String shopEntityId = "00017R07MTBFPI81N0000NBJ43J9P00K";
        String itemSerial = "2345";
        GoodsBaseInfo goodsBaseInfo = this.goodsQueryService.findGoodsByItemSerial(shopEntityId, itemSerial);
        Assert.assertNotNull("查询商品详情失败", goodsBaseInfo);
    }

    /**
     * gasd01
     * @throws Exception
     */
    @Test
    public void testFindGoodsCategory() throws Exception
    {
        String ShopId = null;
        String shopEntityId = "01822UK2PV0226F07GRNHMEIISWR2K8D";
        int pageIndex = 1;
        int pageSize = 10;
        List<GoodsCategoryBusiness> list = this.goodsQueryService.findGoodsCategory(ShopId, shopEntityId, pageIndex, pageSize);
        Assert.assertTrue("查询商品类别失败", CollectionUtils.isNotEmpty(list));
    }

    /**
     * gasd02,gask01,gask03
     * @throws Exception
     */
    @Test
    public void testFindGoods() throws Exception
    {
        String shopId = null;
        String shopEntityId = "01822K7105HMGOM07GRNH4EIISWR2K8D";// "00017R07MTBFPI81N0000NBJ43J9P00K";
        String itemSerial = null;
        String goodsName = null;
        String categoryId = null;
        String priceMin = null;
        String priceMax = null;
        int pageIndex = 1;
        int pageSize = 10;
        String orderByClause = null;
        List<GoodsDetail> list = this.goodsQueryService.findGoods(shopId, shopEntityId, itemSerial, goodsName, categoryId, priceMin, priceMax, pageIndex, pageSize, orderByClause);
        Assert.assertTrue("查询商品信息失败", CollectionUtils.isNotEmpty(list));
    }

    /**
     * 统计商家总店商品数量
     * @throws Exception
     */
    @Test
    public void testCountGeneralGoods() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * mobb04
     * @throws Exception
     */
    @Test
    public void testFindGoodsAndComment() throws Exception
    {
        List<Map<String, String>> goodsInfoList = new ArrayList<Map<String, String>>();
        Map<String, String> goodsInfoMap = new HashMap<String, String>();
        goodsInfoMap.put("goodsid", "00017R7IVJHFHH6AE0025REIISX8Q023");
        goodsInfoMap.put("shopentityid", "00017R5PKIGK0PF8100340EIISX8Q016");
        goodsInfoList.add(goodsInfoMap);
        List<ShopGoodsDetailInfo> shopGoodsDetailInfoList = this.goodsQueryService.findGoodsAndComment(goodsInfoList);
        Assert.assertTrue("获取商品详细信息及评论失败", CollectionUtils.isNotEmpty(shopGoodsDetailInfoList));
    }

    /**
     * 通扫码获取商品信息(目前只用于收藏广场mobe09)
     * @throws Exception
     */
    @Test
    public void testFindGoodsContainComment() throws Exception
    {
        String shopEntityId = "01822JF4R28QLJF07GRNH1EIISWR2K8D";
        String itemSerial = "112";
        List<GoodsContainComment> list = this.goodsQueryService.findGoodsContainComment(shopEntityId, itemSerial);
        Assert.assertTrue("通扫码获取商品信息失败", CollectionUtils.isNotEmpty(list));
    }

    /**
     * gasd02
     * @throws Exception
     */
    @Test
    public void testFindGoodsByCategory() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * mobe04
     * @throws Exception
     */
    @Test
    public void testGetGoodsMenu() throws Exception
    {
        String userId = null;
        String shopEntityId = "01822UK2PV0226F07GRNHMEIISWR2K8D";
        Integer pageIndex = null;
        Integer pageSize = null;
        List<ShopGoodsDetailInfo> shopGoodsDetailInfoList = this.goodsQueryService.getGoodsMenu(userId, shopEntityId, pageIndex, pageSize);
        Assert.assertTrue("获取菜谱失败", CollectionUtils.isNotEmpty(shopGoodsDetailInfoList));
    }
}
