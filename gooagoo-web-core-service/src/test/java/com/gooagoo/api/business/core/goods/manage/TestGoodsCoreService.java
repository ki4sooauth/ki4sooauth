package com.gooagoo.api.business.core.goods.manage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.gooagoo.common.cache.PublishCache;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestGoodsCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public GoodsCoreService goodsCoreService;

    @Override
    @Resource(name = "goodsSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /* *//**
                                                                                         * 删除商品（删除商品基本、营销、特征信息）
                                                                                         * @throws Exception
                                                                                         */
    /*
    @Test
    public void testDeleteGoodsInfo() throws Exception
    {
     String id = "000181JP2Q06UMJUJIB11IBJ43J9P4J8";
     boolean isSucceed = this.goodsCoreService.deleteGoodsInfo(id);
     Assert.isTrue(isSucceed, "删除商品信息");
    }

    *//**
      * 删除商品特征信息
      * @throws Exception
      */
    /*
    @Test
    public void testDeleteGoodsFeatureInfo() throws Exception
    {
     String id = "000181JP3HKACHSECIB11KBJ43J9P4J8";
     boolean isSucceed = this.goodsCoreService.deleteGoodsFeatureInfo(id);
     Assert.isTrue(isSucceed, "删除商品特征");
    }

    */
    /**
      * 发布商品
    */
    @Test
    public void testPublishGoods() throws Exception
    {
        String goodsId = "189VLOQ0R2U6QD00A1BAQJA67CNHKOVV";
        Assert.isTrue(this.goodsCoreService.publishGoods(goodsId), "生成商品静态页面失败[goodsId=" + goodsId + "]");
        /*
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        goodsBaseInfoExample.createCriteria().andPublishStatusEqualTo("P").andIsDelEqualTo("N");
        List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoMapper.selectByExample(goodsBaseInfoExample);
        Assert.isTrue(CollectionUtils.isNotEmpty(goodsBaseInfoList), "批量发布商品失败");
        List<String> goodsIdList = new ArrayList<String>();
        for (GoodsBaseInfo goodsBaseInfo : goodsBaseInfoList)
        {
            goodsIdList.add(goodsBaseInfo.getGoodsId());
        }
        GoodsBaseInfo goodsBaseInfo = new GoodsBaseInfo();
        goodsBaseInfo.setPublishStatus("A");
        goodsBaseInfoExample = new GoodsBaseInfoExample();
        goodsBaseInfoExample.createCriteria().andGoodsIdIn(goodsIdList);
        Assert.isTrue(this.goodsBaseInfoMapper.updateByExampleSelective(goodsBaseInfo, goodsBaseInfoExample) == goodsIdList.size(), "批量更新商品发布状态失败");
        for (String goodsId : goodsIdList)
        {
            if ("0182FRFUJBBU4NQ0OGL5RNEIISWR2QH9".equals(goodsId))
            {
                Assert.isTrue(this.goodsCoreService.publishGoods(goodsId), "生成商品静态页面失败[goodsId=" + goodsId + "]");
            }
            else
            {
                Assert.isTrue(this.goodsCoreService.publishGoods(goodsId), "生成商品静态页面失败[goodsId=" + goodsId + "]");
            }
        }
            */
    }

    /**
     * 重新发布商品
    */
    @Test
    public void testAnewPublishGoods() throws Exception
    {
        String goodsId = "189VLOQ0R2U6QD00A1BAQJA67CNHKOVV";
        Assert.isTrue(this.goodsCoreService.anewPublishGoods(goodsId), "重新生成商品静态页面失败[goodsId=" + goodsId + "]");
    }

    /**
     * 重新发布所有商品(范围:商家、实体店)
     */
    @Test
    public void testAnewAllPublishGoods() throws Exception
    {
        String shopId = "01822IAKR5SKU02085QBP2EIISWR0JGT";
        String shopEntityId = null;
        boolean result = this.goodsCoreService.anewAllPublishGoods(shopId, shopEntityId);
        System.out.println("succeed :" + PublishCache.getSucceedGoodsList().size() + "个");
        System.out.println("failed :" + PublishCache.getFailedGoodsList().size() + "个");
        Assert.isTrue(result, "重新生成商品静态页面失败[shopId=" + shopId + "]");
    }

    /**
     * 添加商品信息
     * @throws Exception
     */
    @Test
    public void testAddGoodsInfo() throws Exception
    {
        GoodsBaseInfo goodsBaseInfo = this.addgoodsbaseinfo();
        GoodsMarketingInfo goodsmarketinginfo = this.addgoodsmarketinginfo();
        GoodsFeatureInfo goodsfeatureinfo1 = this.addgoodsfeatureinfo1();
        GoodsFeatureInfo goodsfeatureinfo2 = this.addgoodsfeatureinfo2();
        List<GoodsFeatureInfo> goodsFeatureInfoList = new ArrayList<GoodsFeatureInfo>();
        goodsFeatureInfoList.add(goodsfeatureinfo1);
        goodsFeatureInfoList.add(goodsfeatureinfo2);
        boolean isSucceed = this.goodsCoreService.addGoodsInfo(goodsBaseInfo, goodsmarketinginfo, goodsFeatureInfoList);
        Assert.isTrue(isSucceed, "添加商品信息成功");

    }

    /**
     * 更新商品信息
     * @throws Exception
     */
    @Test
    public void testUpdateGoodsInfo() throws Exception
    {
        GoodsBaseInfo goodsBaseInfo = this.addgoodsbaseinfo();
        GoodsMarketingInfo goodsMarketingInfo = this.addgoodsmarketinginfo();
        GoodsFeatureInfo goodsFeatureInfo1 = this.addgoodsfeatureinfo1();
        GoodsFeatureInfo goodsFeatureInfo2 = this.addgoodsfeatureinfo2();
        List<GoodsFeatureInfo> goodsFeatureInfoList = new ArrayList<GoodsFeatureInfo>();
        /*goodsFeatureInfoList.add(goodsFeatureInfo1);
        goodsFeatureInfoList.add(goodsFeatureInfo2);*/
        boolean isSucceed = this.goodsCoreService.updateGoodsInfo(goodsBaseInfo, goodsMarketingInfo, goodsFeatureInfoList);
        Assert.isTrue(isSucceed, "更新商品信息成功");

    }

    /**
     * 添加商品基本信息
     * @throws Exception
     */
    private GoodsBaseInfo addgoodsbaseinfo() throws Exception
    {
        GoodsBaseInfo goodsBaseInfo = new GoodsBaseInfo();
        goodsBaseInfo.setGoodsId("00017R5U9MNOJODJP0005CBJ11W37006");
        goodsBaseInfo.setGoodsName("test12");
        goodsBaseInfo.setGoodsBrand("1");
        goodsBaseInfo.setGoodsCategoryRoot("1");
        goodsBaseInfo.setGoodsCategoryLeaf("1");
        goodsBaseInfo.setGoodsSerial("1");
        goodsBaseInfo.setItemSerial("1");
        goodsBaseInfo.setPrice(10.5);
        goodsBaseInfo.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        goodsBaseInfo.setShopEntityId("00017Q3EG198TUUV50000HFYOBYEH003");
        return goodsBaseInfo;
    }

    /**
     * 添加商品营销信息
     * @throws Exception
     */
    private GoodsMarketingInfo addgoodsmarketinginfo() throws Exception
    {
        GoodsMarketingInfo addObject = new GoodsMarketingInfo();
        addObject.setGoodsId("00017R5U9MNOJODJP0005CBJ11W37006");
        addObject.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        addObject.setShopEntityId("00017Q3EG198TUUV50000HFYOBYEH003");
        addObject.setFeature("test11");
        return addObject;
    }

    /**
     * 添加商品特征信息
     * @throws Exception
     */
    private GoodsFeatureInfo addgoodsfeatureinfo1() throws Exception
    {
        GoodsFeatureInfo addObject = new GoodsFeatureInfo();
        addObject.setId("01822TP9V9G73ML07GRNHHEIISWR2K8m");
        addObject.setGoodsName("Hadoop实战");
        addObject.setGoodsId("00017R5U9MNOJODJP0005CBJ11W37006");
        addObject.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        addObject.setFeatureCode("1");
        addObject.setFeatureName("好丽友");
        addObject.setFeatureValue("休闲食品");
        return addObject;
    }

    /**
     * 添加商品特征信息
     * @throws Exception
     */
    private GoodsFeatureInfo addgoodsfeatureinfo2() throws Exception
    {
        GoodsFeatureInfo addObject = new GoodsFeatureInfo();
        addObject.setId("01822TP9V9G73ML07GRNHHEIISWR2K8o");
        addObject.setGoodsName("Hadoop实战");
        addObject.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        addObject.setGoodsId("00017R5U9MNOJODJP0005CBJ11W37006");
        addObject.setFeatureCode("1");
        addObject.setFeatureName("好丽友");
        addObject.setFeatureValue("休闲食品");
        return addObject;
    }

}
